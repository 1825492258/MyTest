package com.item.test.activity.login.presenter;

import com.google.gson.Gson;
import com.item.test.activity.base.BaseModelCallBack;
import com.item.test.activity.login.model.ILoginModel;
import com.item.test.activity.login.model.LoginModelImpl;
import com.item.test.activity.login.model.bean.MSMCode;
import com.item.test.activity.login.model.bean.UserInfo;
import com.item.test.activity.login.view.ILoginView;
import com.item.test.utils.http.impl.BaseResponse;

/**
 * Created by wuzongjie on 2017/11/13.
 *
 */

public class LoginPresenterImpl implements ILoginPresenter{

    private ILoginView mView;
    private ILoginModel mModel;

    public LoginPresenterImpl(ILoginView view){
        this.mView = view;
        mModel = new LoginModelImpl();
    }

    /**
     * 发送验证码
     * @param phone 手机号
     */
    @Override
    public void requestCode(String phone) {
        if(mView == null){
            return;
        }
        mView.showLoading();
        mModel.code(phone, new BaseModelCallBack() {
            @Override
            public void onResponse(BaseResponse response) {
                mView.dismissLoading();
                MSMCode msmCode = new Gson().fromJson(response.getData(),MSMCode.class);
                if("SUCCESS".equals(msmCode.getStatus())){
                    mView.getSuccessCode(msmCode.getData().getVerificationCode());
                }else {
                    mView.getErrorToast(msmCode.getError());
                }
            }

            @Override
            public void onFailure(int code) {
                mView.showError(code);
                mView.dismissLoading();
            }
        });
    }

    /**
     * 登录
     * @param phone 手机号
     * @param code  验证码
     */
    @Override
    public void requestLogin(String phone, String code) {
        if(mView == null){
           return;
        }
        mView.showLoading();
        mModel.login(phone, code, new BaseModelCallBack() {
            @Override
            public void onResponse(BaseResponse response) {
                mView.dismissLoading();
                UserInfo userInfo = new Gson().fromJson(response.getData(),UserInfo.class);
                if("SUCCESS".equals(userInfo.getStatus())){
                    UserInfo.UserInfos.MyInfo info = userInfo.getData().getUserInfo();
                    mView.getSuccessLogin();
                }else {
                    mView.getErrorToast(userInfo.getError());
                }
            }

            @Override
            public void onFailure(int code) {
                mView.dismissLoading();
                mView.showError(code);
            }
        });
    }
}
