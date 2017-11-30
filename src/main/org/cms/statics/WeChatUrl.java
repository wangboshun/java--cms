package cms.statics;

public class WeChatUrl {
    public static final String GetAccess_Token = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={0}&secret={1}";

    public static final String GetCode_UserInfo = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";

    public static final String GetCode_Base = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope=snsapi_base&state=123#wechat_redirect";

    public static final String GetUserInfo = "https://api.weixin.qq.com/cgi-bin/user/info?access_token={0}&openid={1}&lang=zh_CN";

    public static final String GetOpenId = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret={1}&code={2}&grant_type=authorization_code";

    public static final String GetListUserInfo = "https://api.weixin.qq.com/cgi-bin/user/get?access_token={0}&next_openid={1}";

    public static final String CreateMenu="https://api.weixin.qq.com/cgi-bin/menu/create?access_token={0}";
}
