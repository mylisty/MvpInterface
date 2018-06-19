package com.mvp.yunling.myapplication.mvpactivity;

import android.content.Context;

/**
 * Created by yunling on 2018/6/7.
 */
//Model Interface
public interface IDownloadModel {
    /**
     * 下载操作
     * @param url
     */
    void download(String url);

    void next(Context context);
}
