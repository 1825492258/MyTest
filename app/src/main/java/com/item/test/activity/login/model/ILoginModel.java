package com.item.test.activity.login.model;

import com.item.test.activity.base.BaseModelCallBack;

/**
 * Created by wuzongjie on 2017/11/13.
 * 登录的Model
 */

public interface ILoginModel {
    /**
     * 获取验证码
     *
     * @param phone             手机号
     * @param baseModelCallBack 回调
     */
    void code(String phone, BaseModelCallBack baseModelCallBack);

    /**
     * 登录
     *
     * @param phone             手机号
     * @param code              验证码
     * @param baseModelCallBack 回调
     */
    void login(String phone, String code, BaseModelCallBack baseModelCallBack);
}
