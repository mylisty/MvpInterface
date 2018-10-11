package com.mvp.yunling.myapplication.daggermvp.daggerlogin;

import android.os.SystemClock;

import com.mvp.yunling.myapplication.daggermvp.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by yunling on 2018/6/8.
 */

public class Login1Presenter extends BasePresenter<Login1Contract.ILoginModel,Login1Contract.ILoginView> {
    @Inject
    public Login1Presenter(Login1Contract.ILoginModel model, Login1Contract.ILoginView view) {
        super(model, view);
    }


    public void login(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                mView.showLoading();
                SystemClock.sleep(3000);
                mModel.login(mView.getUserName(), mView.getPassword(), new Login1Contract.OnLoginListener() {
                    @Override
                    public void loginSuccess(String userInfoModel) {
                        mView.next();
                        mView.hideLoading();
                    }

                    @Override
                    public void loginFailed() {
                        mView.showFailedError();
                        mView.hideLoading();
                    }
                });
            }
        }.start();

    }
    /**
     * 清除账户名和密码
     */
    public void clear() {
        mView.clearUserName();
        mView.clearPassword();
    }

}
