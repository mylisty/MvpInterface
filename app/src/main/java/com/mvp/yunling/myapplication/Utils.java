package com.mvp.yunling.myapplication;

import android.util.Log;

/**
 * Created by yunling on 2018/9/7.
 */

public class Utils {

    private static final int MIN_DELAY_TIME= 2000;  // 两次点击间隔不能少于2000ms
    private static long lastClickTime;

    public static boolean isFastClick() {
        boolean flag = false;
        long currentClickTime = System.currentTimeMillis();
        if ((currentClickTime - lastClickTime) >= MIN_DELAY_TIME) {
            flag = true;
        }
        lastClickTime = currentClickTime;
        return flag;
    }
}
