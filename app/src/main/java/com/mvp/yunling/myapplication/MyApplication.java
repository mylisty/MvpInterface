package com.mvp.yunling.myapplication;

import android.app.Application;

/**
 * Created by yunling on 2018/9/4.
 */

public class MyApplication extends Application {
    private static MyApplication intance;
    @Override
    public void onCreate() {
        super.onCreate();
        intance = this;
    }
    public  static MyApplication getIntance(){
        if (intance==null){
            intance = new MyApplication();
        }
        return intance;
    }
}
