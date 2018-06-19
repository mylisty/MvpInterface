package com.mvp.yunling.myapplication.daggermvp.daggerlogin;

import com.mvp.yunling.myapplication.daggermvp.base.BaseModel;
import com.mvp.yunling.myapplication.daggermvp.base.BaseView;

/**
 *  Created by yunling on 2018/6/8.
 */

public interface Login1Contract {

    interface ILoginModel extends BaseModel {
        void login(String username, String password, OnLoginListener loginListener);
    }
    interface ILoginView extends BaseView {

        String getUserName();

        String getPassword();

        void clearUserName();

        void clearPassword();

        void showLoading();

        void hideLoading();

        void next();

        void showFailedError();
    }

    interface OnLoginListener{
        void loginSuccess(String userInfoModel);

        void loginFailed();
    }
}
