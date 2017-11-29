package cms.controller.wechat;

import cms.controller.ControllerBase;
import cms.statics.WeChatUrl;
import cms.utils.http.HttpHelper;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cms.utils.string.Format.StringFormat;

@RestController
@RequestMapping("/wechat/")
public class MpBaseController extends ControllerBase {

    @RequestMapping("token")
    public String GetAccess_Token(String appid, String secret) {
        String url = StringFormat(WeChatUrl.GetAccess_Token, appid, secret);
        String returnurl = HttpHelper.Get(url);
        JSONObject json = new JSONObject(returnurl);
        String token = json.getString("access_token");
        return token;
    }
}
