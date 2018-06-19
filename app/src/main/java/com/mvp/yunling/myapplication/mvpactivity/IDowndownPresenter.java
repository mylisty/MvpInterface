package com.mvp.yunling.myapplication.mvpactivity;

import android.content.Context;
import android.view.View;

/**
 * Created by yunling on 2018/6/7.
 */

public interface IDowndownPresenter {
    /**
     * 下载
     * @param url
     */
    void download(String url);

    /**
     * 下载成功
     * @param result
     */
    void downloadSuccess(String result);

    /**
     * 当前下载进度
     * @param progress
     */
    void downloadProgress(int progress);

    /**
     * 下载失败
     */
    void downloadFail();

    void next(Context context);

}
