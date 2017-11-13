package com.item.test.application;

import android.app.Application;

/**
 * Created by wuzongjie on 2017/11/13.
 * 项目的基类
 */

public class MyApplication extends Application {
    private static MyApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static MyApplication getInstance() {
        return mApplication;
    }
}
