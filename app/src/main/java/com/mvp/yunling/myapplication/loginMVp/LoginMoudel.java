package com.mvp.yunling.myapplication.loginMVp;


import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

/**
 * Created by yunling on 2018/6/8.
 */

public class LoginMoudel implements IDLoginMOdel{

    private LoginPresenter loginPresenter;

    LoginMoudel(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @SuppressLint("HandlerLeak")
    private
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    loginPresenter.success("成功");
                    break;
                case 2:
                    loginPresenter.fail("密码错误");
                    break;
            }
        }
    };
    @Override
    public void login(String password) {
        //发起的网络请求
        Message msg = Message.obtain();
        if ("1111".equals(password)){
            msg.what= 1;
        }else {
            msg.what=2;
        }
        msg.obj=password;
        handler.sendMessage(msg);
    }
}
