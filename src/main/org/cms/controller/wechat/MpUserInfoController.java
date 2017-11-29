package cms.controller.wechat;

import cms.controller.ControllerBase;
import cms.core.wechat.userinfo.ListUser;
import cms.statics.WeChatUrl;
import cms.utils.http.HttpHelper;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cms.utils.string.Format.StringFormat;

@RestController
@RequestMapping("/wechat/")
public class MpUserInfoController extends ControllerBase {

    @Autowired
    private MpBaseController mpbase;

    @RequestMapping("userinfo")
    public String GetUserInfo(String appid) {
        String secret = redis.get("wechat_secret_" + appid);
        String openid = redis.get("wechat_openid_" + appid);
        String token = mpbase.GetAccess_Token(appid, secret);
        String url = StringFormat(WeChatUrl.GetUserInfo, token, openid);
        String val = HttpHelper.Get(url);
        redis.set("wechat_userinfo_" + appid, val);
        return val;
    }

    @RequestMapping("listuser")
    public String GetListUserInfo(String appid, String secret) {
        String token = mpbase.GetAccess_Token(appid, secret);
        String url = StringFormat(WeChatUrl.GetListUserInfo, token, "");
        String list = HttpHelper.Get(url);
        ListUser obj = JSON.parseObject(list, ListUser.class);

        return list;
    }
}
