package cms.controller;

import cms.core.UserInfo;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

@Controller
public class UserInfoController {

    private static Logger log = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private Jedis jedis;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private cms.service.UserInfoService userinfoservice;

    @RequestMapping("/test")
    public String test1(Model model) {
        log.debug("----------------------test1----------------------");

        jedis.set("jedis---test", "12345");
        String str = jedis.get("jedis---test");

        log.debug("----------------------jedis---test：----------------------" + str);

        redisTemplate.opsForValue().set("redisTemplate---test", "67890");
        String str1 = redisTemplate.opsForValue().get("redisTemplate---test").toString();

        log.debug("----------------------redisTemplate---test：----------------------" + str1);

        List<UserInfo> list = userinfoservice.GetList(0, 10);
        UserInfo u = new UserInfo();
        u.setName("a");
        u.setCreate_time(new Date());
        userinfoservice.AddOps(u);
        int number = userinfoservice.GetCount();
        log.debug("----------------------插入自增Id：----------------------" + u.getId());
        log.debug("----------------------总条目：----------------------" + number);
        model.addAttribute("message", "222");
        model.addAttribute("list", list);
        return "test";
    }

    @RequestMapping("/test.html")
    public String test2() {
        return "test";
    }

    @RequestMapping("/json")
    @ResponseBody
    public List<UserInfo> json() {
        List<UserInfo> list = userinfoservice.GetList(0, 10);
        return list;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile[] file, HttpServletRequest request) throws UnsupportedEncodingException {
        String path = request.getServletContext().getRealPath("/upload");
        if (!new File(path).exists())
            new File(path).mkdir();
        for (MultipartFile m : file) {
            File f = new File(path, new String(m.getOriginalFilename().getBytes(), "UTF-8"));//防止中文乱码
            try {
                m.transferTo(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "ok";
    }

    @RequestMapping("/download")
    @ResponseBody
    public String download(@RequestParam("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) {
        if (fileName != null) {
            String realPath = request.getServletContext().getRealPath("/upload");
            File file = new File(realPath, fileName);
            if (file.exists()) {
                try {
                    fileName = new String("图片.jpg".getBytes("UTF-8"), "iso-8859-1");//中文名称乱码问题
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}
