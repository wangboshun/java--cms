package cms.controller.wechat;

import cms.controller.ControllerBase;
import cms.statics.WeChatUrl;
import org.springframework.web.bind.annotation.ResponseBody;
import cms.utils.http.HttpHelper;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static cms.utils.string.format.StringFormat;

@Controller
@RequestMapping("/wechat/")
public class MpUserInfoController extends ControllerBase {

    @RequestMapping("userinfo")
    @ResponseBody
    public String GetUserInfo(String appid) {
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
