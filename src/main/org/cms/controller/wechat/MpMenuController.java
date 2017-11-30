package cms.controller.wechat;

import cms.controller.ControllerBase;
import cms.core.wechat.menu.Button;
import cms.core.wechat.menu.MenuList;
import cms.core.wechat.menu.Sub_button;
import cms.statics.WeChatUrl;
import com.alibaba.fastjson.JSON;
import com.xiaoleilu.hutool.http.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static cms.utils.string.Format.StringFormat;

@RestController
@RequestMapping("/wechat/")
public class MpMenuController extends ControllerBase {

    @Autowired
    private MpBaseController mpbase;

    @RequestMapping("createmenu")
    public String CreateMenu(String appid, String secret) {

        String json = Generate();

        String token = mpbase.GetAccess_Token(appid, secret);

        String url = StringFormat(WeChatUrl.CreateMenu, token);

        return HttpUtil.post(url, json);
    }

    public String Generate() {
        MenuList list = new MenuList();

        Button button1 = new Button();
        Button button2 = new Button();

        Sub_button sub_button1 = new Sub_button("scancode_waitmsg", "扫码带提示", "rselfmenu_0_0", null);
        Sub_button sub_button2 = new Sub_button("scancode_push", "扫码推事件", "rselfmenu_0_1", null);

        Sub_button sub_button3 = new Sub_button("pic_sysphoto", "系统拍照发图", "rselfmenu_1_0", null);
        Sub_button sub_button4 = new Sub_button("pic_photo_or_album", "拍照或者相册发图", "rselfmenu_1_1", null);
        Sub_button sub_button5 = new Sub_button("pic_weixin", "微信相册发图", "rselfmenu_1_2", null);

        List<Sub_button> listsub1 = new ArrayList<>();

        List<Sub_button> listsub2 = new ArrayList<>();

        listsub1.add(sub_button1);
        listsub1.add(sub_button2);

        button1.setSub_button(listsub1);
        button1.setName("菜单1");

        listsub2.add(sub_button3);
        listsub2.add(sub_button4);
        listsub2.add(sub_button5);

        button2.setSub_button(listsub2);
        button2.setName("菜单2");

        List<Button> bu = new ArrayList<>();

        bu.add(button1);
        bu.add(button2);

        list.setButton(bu);

        return JSON.toJSONString(list);
    }

}
