package cms.controller;

import cms.core.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

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
}
