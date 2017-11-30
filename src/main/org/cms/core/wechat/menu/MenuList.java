/**
 * Copyright 2017 bejson.com
 */
package cms.core.wechat.menu;
import java.util.List;

public class MenuList {

    private List<Button> button;
    public void setButton(List<Button> button) {
        this.button = button;
    }
    public List<Button> getButton() {
        return button;
    }

}