package com.item.test.activity.login.model.bean;

import java.io.Serializable;

/**
 * Created by wuzongjie on 2017/11/14.
 * ImageBean
 */

public class ImageBean implements Serializable {
    private String desc;
    private String url;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
