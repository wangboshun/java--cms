package cms.controller.wechat;

import cms.statics.WeChatUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import cms.utils.http.HttpHelper;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;

import static cms.utils.string.format.StringFormat;

@Controller
@RequestMapping("/wechat/")
public class MpUserInfoController {

    public static Logger log = LoggerFactory.getLogger(cms.controller.admin.UserInfoController.class);

    @Autowired
    public Jedis redis;

    @Autowired
    public RedisTemplate redisTemplate;

    @Autowired
    public HttpServletRequest request;

    @Autowired
    public HttpServletResponse response;

    @RequestMapping("userinfo")
    @ResponseBody
    public String GetUserInfo(String appid) throws UnsupportedEncodingException {
        String secret = redis.get("wechat_secret_" + appid);
        String openid = redis.get("wechat_openid_" + appid);
        String url1 = StringFormat(WeChatUrl.GetAccess_Token, appid, secret);
        String returnurl = HttpHelper.Get(url1);
        JSONObject json = new JSONObject(returnurl);
        String token = json.getString("access_token");
        String url = StringFormat(WeChatUrl.GetUserInfo, token, openid);
        String val = HttpHelper.Get(url);
        redis.set("wechat_userinfo_" + appid, val);
        return val;
    }
}
