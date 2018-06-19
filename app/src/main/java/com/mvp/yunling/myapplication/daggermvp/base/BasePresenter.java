package com.mvp.yunling.myapplication.daggermvp.base;

import android.net.IpPrefix;

/**
 * Created by yunling on 2018/6/8.
 */

public class BasePresenter <M extends BaseModel,V extends BaseView> implements IPresenter{

    protected M mModel;

    protected V mView;

    public BasePresenter(M model, V view) {
        mModel = model;
        mView = view;
    }

    public BasePresenter(V view) {
        mView = view;
    }

    @Override
    public void onDestroy() {
        if (mModel != null) {
            mModel.onDestory();
        }
        this.mModel = null;
        this.mView = null;
    }
}
