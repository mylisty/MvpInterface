package com.mvp.yunling.myapplication.mvpactivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

import com.mvp.yunling.myapplication.daggermvp.daggerlogin.DaggerLoginActivity;
import com.mvp.yunling.myapplication.loginMVp.LoginActivity;

/**
 * Created by yunling on 2018/6/7.
 */

public class DownloadModel implements IDownloadModel  {
    private IDowndownPresenter mIDowndownPresenter;
    private MyHandler mMyHandler = new MyHandler();

    public DownloadModel(IDowndownPresenter IDowndownPresenter) {
        mIDowndownPresenter = IDowndownPresenter;
    }

    @Override
    public void download(String url) {
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 101; i++) {
                    Message msg = Message.obtain();
                    msg.what=300;
                    msg.arg1=i;
                    mMyHandler.handleMessage(msg);
                    SystemClock.sleep(50);
                }
            }
        }.start();

    }

    @Override
    public void next(Context context) {
        context.startActivity(new Intent(context.getApplicationContext(), DaggerLoginActivity.class));
    }

    @SuppressLint("HandlerLeak")
    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 300:
                    int percent = msg.arg1;
                    Log.e("aaaaaaaaaaaaa 进度",String.valueOf(percent));
                    if (percent < 100) {
                        mIDowndownPresenter.downloadProgress(percent);
                    } else {
                        mIDowndownPresenter.downloadSuccess("successs");
                    }
                    break;
                case 404:
                    mIDowndownPresenter.downloadFail();
                    break;
                default:
                    break;
            }
        }
    }

}
