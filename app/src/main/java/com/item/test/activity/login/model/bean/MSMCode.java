package com.item.test.activity.login.model.bean;

import com.item.test.utils.http.biz.BaseBizResponse;

/**
 * Created by wuzongjie on 2017/11/13.
 */

public class MSMCode extends BaseBizResponse {

    private Verification data;

    public Verification getData() {
        return data;
    }

    public void setData(Verification data) {
        this.data = data;
    }

    public static class Verification {
        private String verificationCode;

        public String getVerificationCode() {
            return verificationCode;
        }

        public void setVerificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
        }
    }
}
