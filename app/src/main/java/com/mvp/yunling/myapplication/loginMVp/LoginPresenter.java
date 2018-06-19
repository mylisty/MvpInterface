package com.mvp.yunling.myapplication.loginMVp;

/**
 * Created by yunling on 2018/6/8.
 */

public interface LoginPresenter {
    void login(String password);
    /**
     * 成功
     */
    void success(String bean);

    /**
     * 失败原因
     * @param reason
     */
    void fail(String reason);
}
