package com.item.test.activity.login.model.bean;

import java.io.Serializable;

/**
 * Created by wuzongjie on 2017/11/13.
 */

public class Bills implements Serializable {
    private String number; // 账单编号
    private String customerType; // 使用者类型
    private String phoneNumber; // 账单所属者电话号码
    private String remark; // 说明
    private String amount; // 金额
    private String payment; // 支付方式
    private String type; // 类型 1:支出 2:收入
    private String createTime; // 时间

    public String getNumber() {
        return number;
    }

    public String getCustomerType() {
        return customerType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRemark() {
        return remark;
    }

    public String getAmount() {
        return amount;
    }

    public String getPayment() {
        return payment;
    }

    public String getType() {
        return type;
    }

    public String getCreateTime() {
        return createTime;
    }
}
