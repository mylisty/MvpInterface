package com.mvp.yunling.myapplication.daggermvp.daggerlogin;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by yunling on 2018/6/8.
 */
//Model 层主要是对数据操作的，我们这里开启线程模拟登录操作:
public class LoginModel implements Login1Contract.ILoginModel {
    @Inject
    public LoginModel() {
    }

    @Override
    public void onDestory() {
        // 销毁持有的引用
    }

    @Override
    public void login(String username, String password, Login1Contract.OnLoginListener loginListener) {
        Log.e("aaaaaaa","username"+username);
        Log.e("aaaaaaa","password"+password);
        if ("1111".equals(password)){
            loginListener.loginSuccess("successBean");
        }else {
            loginListener.loginFailed();
        }

    }
}
