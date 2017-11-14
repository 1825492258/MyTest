package com.item.test.utils;

/**
 * Created by wuzongjie on 2017/10/28.
 */

public class HttpConstants {
    /**
     * 服务器地址
     */
    private final static String SERVER_URL = "http://192.168.3.20:8083/smarttransport-bms/";
    /**
     * 2.1.3 获取验证码
     * get
     * http://192.168.3.20:8083/smarttransport-bms/verification-code/phoneNumber
     */
    public final static String VERIFICATION_CODE_URL = SERVER_URL + "verification-code/";
    /**
     * 2.2.1 用户登录
     * get
     * http://192.168.3.20:8083/smarttransport-bms/login-consumer?phoneNumber=18356025758&verificationCode=9009
     */
    public final static String LOGIN_CONSUMER_URL = SERVER_URL + "login-consumer?phoneNumber={phoneNumber}&verificationCode={verificationCode}";

    /**
     * 2.8.4账单查询
     * get http://domain/v1/projectName/bills/my-bills?pageNumber=1&pageSize=20
     */
    public final static String BILLS_URL = SERVER_URL + "bills/my-bills?pageNumber={pageNumber}&pageSize={pageSize}";

    public final static String PAY_URL = "http://192.168.3.20:8083/smarttransport-bms/alipay-sign";
    public  final static String JJ = "http://cloud.bmob.cn/f34e28da5816433d/getMsgCode?phone={phone}";

    public final static String MY_WALLET_URL = SERVER_URL + "my-wallet";
}
