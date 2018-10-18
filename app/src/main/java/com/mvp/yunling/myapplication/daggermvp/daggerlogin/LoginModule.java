package com.mvp.yunling.myapplication.daggermvp.daggerlogin;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 *  Created by yunling on 2018/6/8.
 */
@Module
public  class LoginModule {
    private Login1Contract.ILoginView iLoginView;

    public LoginModule(Login1Contract.ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }
    @Provides
    Login1Contract.ILoginView getView() {
        return iLoginView;
    }

    @Provides
    Login1Contract.ILoginModel getModel(LoginModel model) {
        return model;
    }

}
