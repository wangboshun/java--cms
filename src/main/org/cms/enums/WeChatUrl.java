package cms.enums;

public enum WeChatUrl {

    GetAccess_Token("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={0}&secret={1}"),

    GetCode_UserInfo("https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect"),

    GetCode_Base("https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope=snsapi_base&state=123#wechat_redirect"),

    GetUserInfo("https://api.weixin.qq.com/cgi-bin/user/info?access_token={0}&openid={1}&lang=zh_CN"),

    GetOpenId("https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret={1}&code={2}&grant_type=authorization_code");

    private String val;

    public String getVal() {
        return val;
    }

    WeChatUrl(String str) {
        this.val = str;
    }

}
