package com.item.test.utils.common;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.item.test.application.MyApplication;

import java.util.regex.Pattern;

/**
 * Created by wuzongjie on 2017/11/13.
 * 定义自定义吐司 以及对权限的判断
 */

public class ToashUtils {

    private static Toast mToast; // 吐司

    /**
     * 定义吐司
     *
     * @param msg 吐司的内容
     */
    @SuppressLint("ShowToast")
    public static void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.getInstance(), "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }

    /**
     * 判断是否有指定的权限
     *
     * @param activity    上下文
     * @param permissions 权限
     * @return 是否有权限
     */
    public static boolean hasPermission(AppCompatActivity activity, String... permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 申请指定的权限
     *
     * @param activity    上下文
     * @param code        code
     * @param permissions 权限
     */
    public static void requestPermission(AppCompatActivity activity, int code, String... permissions) {
        if (Build.VERSION.SDK_INT >= 23) {
            activity.requestPermissions(permissions, code);
        }
    }

    /**
     * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
     *
     * @param mobile 移动、联通、电信运营商的号码段
     *               <p>移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
     *               、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）</p>
     *               <p>联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）</p>
     *               <p>电信的号段：133、153、180（未启用）、189</p>
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkMobile(String mobile) {
        String regex = "(\\+\\d+)?1[3458]\\d{9}$";
        return Pattern.matches(regex, mobile);
    }
}
