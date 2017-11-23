package wechat.controller;

import webbase.controller.RestControllerBase;
import cms.utils.http.HttpHelper;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class OauthRestController extends RestControllerBase {

    @RequestMapping("/wechat/code")
    @ResponseBody
    public void GetCode(HttpServletRequest request, HttpServletResponse response, String appid, String secret) throws IOException {

        redis.set("wechat_appid" + appid, appid);
        redis.set("wechat_secret" + appid, secret);

        String returnurl = request.getScheme() + "://" + request.getServerName() + "/wechat/openid?appid=" + appid;
        String encodeurl = URLEncoder.encode(returnurl, "UTF-8");
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri=" +
                encodeurl + "&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
        response.sendRedirect(url);
    }

    @RequestMapping("/wechat/openid")
    @ResponseBody
    public void GetOpenId(HttpServletRequest request, HttpServletResponse response, String appid, String code) throws IOException {
        String secret = redis.get("wechat_secret" + appid);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code ";
        String val = HttpHelper.Get(url);

        JSONObject json = new JSONObject(val);
        String openid = json.getString("openid");

        redis.set("wechat_openid" + appid, openid);

        String returnurl = request.getScheme() + "://" + request.getServerName() + "/wechat/userinfo" + "?appid=" + appid;
        response.sendRedirect(returnurl);
    }
}
