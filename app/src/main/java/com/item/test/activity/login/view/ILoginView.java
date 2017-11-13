package com.item.test.activity.login.view;

import com.item.test.activity.base.IView;

/**
 * Created by wuzongjie on 2017/11/13.
 */

public interface ILoginView extends IView {
    void getSuccessCode(String code);
    void getErrorToast(String message);
    void getSuccessLogin();
}
