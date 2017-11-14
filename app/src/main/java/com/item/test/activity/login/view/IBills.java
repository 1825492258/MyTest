package com.item.test.activity.login.view;

import com.item.test.activity.base.IView;
import com.item.test.activity.login.model.bean.ImageBean;

import java.util.List;

/**
 * Created by wuzongjie on 2017/11/13.
 */

public interface IBills extends IView {

    void onRefresh(List<ImageBean> list);

    void onLoadMore(List<ImageBean> list);

    void onFailureRefresh(int code,int type);
}
