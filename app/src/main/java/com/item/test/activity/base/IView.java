package com.item.test.activity.base;

/**
 * Created by wuzongjie on 2017/11/13.
 * 基本View的实现
 */

public interface IView {
    /**
     * 展示Loading
     */
    void showLoading();

    /**
     * 隐藏Loading
     */
    void dismissLoading();

    /**
     * 错误
     * @param code 错误码
     */
    void showError(int code);
}
