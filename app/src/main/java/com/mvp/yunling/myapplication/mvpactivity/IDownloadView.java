package com.mvp.yunling.myapplication.mvpactivity;

/**
 * Created by yunling on 2018/6/7.
 */
//View Interface
public interface IDownloadView {
    /**
     * 显示进度条 //annotation
     * @param show
     */
    void showProgressBar(boolean show);

    /**
     * 设置进度条进度
     * @param progress
     */
    void setProcessProgress(int progress);

    /**
     * 根据数据设置view
     * @param result
     */
    void setView(String result);

    /**
     * 设置请求失败时的view
     */
    void showFailToast();

}
