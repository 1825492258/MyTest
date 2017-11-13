package com.item.test.activity.base;

import com.item.test.utils.http.impl.BaseResponse;

/**
 * Created by wuzongjie on 2017/11/13.
 * model 网络请求结束的回调
 */

public interface BaseModelCallBack {
    void onResponse(BaseResponse response);

    void onFailure(int code); // 失败这里只返回状态码
}
