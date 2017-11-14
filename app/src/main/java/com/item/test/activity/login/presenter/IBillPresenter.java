package com.item.test.activity.login.presenter;

/**
 * Created by wuzongjie on 2017/11/14.
 */

public interface IBillPresenter {
    /**
     * 获取数据
     * @param page 页号
     * @param type 类型
     */
    void requestBill(int page, int type);
}
