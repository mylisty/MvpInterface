package com.mvp.yunling.myapplication.daggermvp.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;


/**
 *  Created by yunling on 2018/6/8.
 */

@SuppressLint("Registered")
public abstract class BaseMvpActivity<T extends BasePresenter> extends AppCompatActivity {
    @Inject
   public T mPresenter;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null!=mPresenter){
            mPresenter.onDestroy();
        }
        this.mPresenter=null;

    }
}
