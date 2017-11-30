/**
 * Copyright 2017 bejson.com
 */
package cms.core.wechat.menu;

import java.util.List;

public class Sub_button {

    private String type;
    private String name;
    private String key;
    private List<String> sub_button;

    public Sub_button(String type, String name, String key, List<String> sub_button) {
        this.type = type;
        this.name = name;
        this.key = key;
        this.sub_button = sub_button;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setSub_button(List<String> sub_button) {
        this.sub_button = sub_button;
    }

    public List<String> getSub_button() {
        return sub_button;
    }

}