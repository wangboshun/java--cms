package cms.controller.wechat;

import cms.controller.ControllerBase;
import cms.statics.WeChatUrl;

import org.springframework.stereotype.Controller;
import cms.utils.http.HttpHelper;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URLEncoder;

import static cms.utils.string.format.StringFormat;

@Controller
@RequestMapping("/wechat/")
public class MpOauthController extends ControllerBase {

    @RequestMapping("code")
    @ResponseBody
    public void GetCode(String appid, String secret) throws IOException {
        redis.set("wechat_appid_" + appid, appid);
        redis.set("wechat_secret_" + appid, secret);
        String returnurl = request.getScheme() + "://" + request.getServerName() + "/wechat/openid?appid=" + appid;
        String encodeurl = URLEncoder.encode(returnurl, "UTF-8");
        String url = StringFormat(WeChatUrl.GetCode_UserInfo, appid, encodeurl);
        response.sendRedirect(url);
    }

    @RequestMapping("openid")
    @ResponseBody
    public void GetOpenId(String appid, String code) throws IOException {
        String secret = redis.get("wechat_secret_" + appid);
        String url = StringFormat(WeChatUrl.GetOpenId, appid, secret, code);
        String val = HttpHelper.Get(url);

        JSONObject json = new JSONObject(val);
        String openid = json.getString("openid");

        redis.set("wechat_openid_" + appid, openid);

        String returnurl = request.getScheme() + "://" + request.getServerName() + "/wechat/userinfo" + "?appid=" + appid;
        response.sendRedirect(returnurl);
    }
}
