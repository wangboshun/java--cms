package cms.controller.wechat;

import cms.controller.ControllerBase;
import cms.core.wechat.TextMsg;
import cms.utils.secret.wechat.AesException;
import cms.utils.secret.wechat.SHA1;
import cms.utils.xml.XmlUtil;
import com.thoughtworks.xstream.XStream;
import com.xiaoleilu.hutool.util.StrUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import static cms.utils.string.Format.StringFormat;

@RestController
@RequestMapping("/wechat/")
public class MpMsgController extends ControllerBase {

    private InputStream inputStream;

    private String server_data;

    private String signature;

    private String timestamp;

    private String nonce;

    private String echostr;

    @RequestMapping(value = "service")
    public void ServiceCheck() throws Exception {
        response.setCharacterEncoding("UTF-8");

        inputStream = request.getInputStream();
        server_data = IOUtils.toString(inputStream, "UTF-8");
        signature = request.getParameter("signature");
        timestamp = request.getParameter("timestamp");
        nonce = request.getParameter("nonce");
        echostr = request.getParameter("echostr");

        Map<String, Object> map = XmlUtil.xmlStrToMap(server_data);

        if (StrUtil.isEmpty(server_data))
            Check();

        SendDetail(map);
//        switch (map.get("MsgType").toString()) {
//            case "text":
//                SendTxtMsg(map);
//                break;
//            case "image":
//                SendImageMsg(map);
//                break;
//        }
    }

    //发送文字消息
    public void SendTxtMsg(Map<String, Object> map) throws IOException {
        TextMsg txt = new TextMsg();
        txt.setToUserName(map.get("FromUserName").toString());
        txt.setFromUserName(map.get("ToUserName").toString());
        txt.setCreateTime(new Date().getTime());
        txt.setMsgType("text");
        txt.setContent(map.get("Content").toString());
        XStream xStream = new XStream();
        xStream.alias("xml", txt.getClass());

        String xml = xStream.toXML(txt);

        System.out.println(xml);
        response.getWriter().write(xml);
    }

    //发送图片消息
    public void SendImageMsg(Map<String, Object> map) throws IOException {

        String str = "<xml>\n" +
                "<ToUserName><![CDATA[{0}]]></ToUserName>\n" +
                "<FromUserName><![CDATA[{1}]]></FromUserName>\n" +
                "<CreateTime>{2}</CreateTime>\n" +
                "<MsgType><![CDATA[image]]></MsgType>\n" +
                "<Image>\n" +
                "<MediaId><![CDATA[{3}]]></MediaId>\n" +
                "</Image>\n" +
                "</xml>";
        String xml = StringFormat(str, new Object[]{map.get("FromUserName").toString(), map.get("ToUserName").toString(), new Date().getTime(), map.get("MediaId").toString()});

        System.out.println(xml);
        response.getWriter().write(xml);
    }

    public void SendDetail(Map<String, Object> map) throws IOException {

        String str = "<xml>\n" +
                "<ToUserName><![CDATA[{0}]]></ToUserName>\n" +
                "<FromUserName><![CDATA[{1}]]></FromUserName>\n" +
                "<CreateTime>{2}</CreateTime>\n" +
                "<MsgType><![CDATA[news]]></MsgType>\n" +
                "<ArticleCount>{3}</ArticleCount>\n" +
                "<Articles>\n" +
                "<item>\n" +
                "<Title><![CDATA[{4}]]></Title> \n" +
                "<Description><![CDATA[{5}]]></Description>\n" +
                "<PicUrl><![CDATA[{6}]]></PicUrl>\n" +
                "<Url><![CDATA[{7}]]></Url>\n" +
                "</item>\n" +
                "<item>\n" +
                "<Title><![CDATA[{4}]]></Title> \n" +
                "<Description><![CDATA[{5}]]></Description>\n" +
                "<PicUrl><![CDATA[{6}]]></PicUrl>\n" +
                "<Url><![CDATA[{7}]]></Url>\n" +
                "</item>\n" +
                "<item>\n" +
                "<Title><![CDATA[{4}]]></Title> \n" +
                "<Description><![CDATA[{5}]]></Description>\n" +
                "<PicUrl><![CDATA[{6}]]></PicUrl>\n" +
                "<Url><![CDATA[{7}]]></Url>\n" +
                "</item>\n" +
                "</Articles>\n" +
                "</xml>";

        String xml = StringFormat(str, new Object[]{map.get("FromUserName").toString(), map.get("ToUserName").toString(), new Date().getTime(), "3", "标题", "详情", "https://ss2.bdstatic.com/kfoZeXSm1A5BphGlnYG/skin/65.jpg", "http://www.qq.com"});

        System.out.println(xml);
        response.getWriter().write(xml);
    }

    //服务器设置检查
    public void Check() throws IOException {
        String mySignature = null;

        try {
            mySignature = SHA1.getSHA1("token", timestamp, nonce);
        } catch (AesException e) {
            e.printStackTrace();
        }

        if (null != mySignature && !"".equals(mySignature) && mySignature.equals(signature))
            if (null != echostr)
                response.getWriter().write(echostr);

    }
}
