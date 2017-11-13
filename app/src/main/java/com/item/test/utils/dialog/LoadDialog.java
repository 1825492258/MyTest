package com.item.test.utils.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.item.test.R;

/**
 * Created by wuzongjie on 2017/11/13.
 * 自定义一个加载弹窗
 * 注： 设置屏幕背景不变暗 可以在style中添加如下代码
 * <item name="android:windowBackground"> @android:color/transparent </item>
 * <item name="android:backgroundDimEnabled">false</item>
 */

public class LoadDialog extends Dialog {

    public LoadDialog(@NonNull Context context) {
        super(context, R.style.load_dialog);
        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
    }
}
