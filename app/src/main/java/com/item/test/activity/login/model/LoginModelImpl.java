package com.item.test.activity.login.model;

import com.item.test.activity.base.BaseModelCallBack;
import com.item.test.utils.HttpConstants;
import com.item.test.utils.http.IHttpClient;
import com.item.test.utils.http.IRequest;
import com.item.test.utils.http.impl.BaseRequest;
import com.item.test.utils.http.impl.BaseResponse;
import com.item.test.utils.http.impl.OKHttpClientImp;

/**
 * Created by wuzongjie on 2017/11/13.
 * Model 的实现类
 */

public class LoginModelImpl implements ILoginModel{
    /**
     * 获取验证码
     * @param phone             手机号
     * @param baseModelCallBack 回调
     */
    @Override
    public void code(String phone, final BaseModelCallBack baseModelCallBack) {
        IRequest request = new BaseRequest(HttpConstants.VERIFICATION_CODE_URL + phone);
        OKHttpClientImp.getInstance().get(request, false, new IHttpClient.RequestCallBack() {
            @Override
            public void onSuccess(BaseResponse response) {
                baseModelCallBack.onResponse(response);
            }

            @Override
            public void onFailure(int code) {
                baseModelCallBack.onFailure(code);
            }
        });
    }

    /**
     * 获取手机号
     * @param phone             手机号
     * @param code              验证码
     * @param baseModelCallBack 回调
     */
    @Override
    public void login(String phone, String code, final BaseModelCallBack baseModelCallBack) {
        IRequest request = new BaseRequest(HttpConstants.LOGIN_CONSUMER_URL);
        request.setBody("phoneNumber", phone);
        request.setBody("verificationCode", code);
        OKHttpClientImp.getInstance().get(request, false, new IHttpClient.RequestCallBack() {
            @Override
            public void onSuccess(BaseResponse response) {
                baseModelCallBack.onResponse(response);
            }

            @Override
            public void onFailure(int code) {
                baseModelCallBack.onFailure(code);
            }
        });
    }
}
