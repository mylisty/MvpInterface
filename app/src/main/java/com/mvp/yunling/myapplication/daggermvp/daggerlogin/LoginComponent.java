package com.mvp.yunling.myapplication.daggermvp.daggerlogin;

import javax.inject.Scope;

import dagger.Component;

/**
 * Created by yunling on 2018/6/8.
 */

@Component(modules = LoginModule.class)
public interface LoginComponent {
    void inject(DaggerLoginActivity daggerLoginActivity);
}
