package com.item.test.activity.login.presenter;

/**
 * Created by wuzongjie on 2017/11/13.
 * 登录的Presenter
 */

public interface ILoginPresenter {
    /**
     * 获取验证码
     *
     * @param phone 手机号
     */
    void requestCode(String phone);

    /**
     * 登录
     *
     * @param phone 手机号
     * @param code  验证码
     */
    void requestLogin(String phone, String code);
}
