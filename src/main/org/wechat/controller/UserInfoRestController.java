package wechat.controller;

import webbase.controller.RestControllerBase;
import cms.utils.http.HttpHelper;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserInfoRestController extends RestControllerBase {

    @RequestMapping("/wechat/userinfo")
    public String GetUserInfo(HttpServletRequest request, HttpServletResponse response, String appid) {
        String secret = redis.get("wechat_secret" + appid);
        String openid = redis.get("wechat_openid" + appid);
        String url1 = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret;
        String returnurl = HttpHelper.Get(url1);
        JSONObject json = new JSONObject(returnurl);
        String token = json.getString("access_token");
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + token + "&openid=" + openid + "&lang=zh_CN";
        String val = HttpHelper.Get(url);
        redis.set("wechat_userinfo" + appid, val);
        return val;
    }
}
