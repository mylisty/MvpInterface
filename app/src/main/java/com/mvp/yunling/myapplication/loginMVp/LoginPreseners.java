package com.mvp.yunling.myapplication.loginMVp;

/**
 * Created by yunling on 2018/6/8.
 */

public class LoginPreseners implements LoginPresenter {

    private IDLoginMOdel idLoginMOdel;
    private IDLoginView idLoginView;
    protected LoginPreseners(IDLoginView idLoginView) {
       this. idLoginView = idLoginView;
        this.idLoginMOdel = new LoginMoudel(this) ;
    }

    @Override
    public void login(String password) {
        idLoginMOdel.login(password);
    }

    @Override
    public void success(String bean) {
        idLoginView.success(bean);
    }

    @Override
    public void fail(String reason) {
        idLoginView.fail(reason);
    }
}
