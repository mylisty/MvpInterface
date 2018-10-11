package com.mvp.yunling.myapplication.mvpactivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mvp.yunling.myapplication.R;
import com.mvp.yunling.myapplication.Utils;


/**
 *  Created by yunling on 2018/6/7.
 */

public class MVPActivity  extends AppCompatActivity implements IDownloadView {
    private Context mContext;
    private ProgressDialog progressDialog;

    private DownloadPresenter mDownloadPresenter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_mvp);
        init();
    }

    private void init() {
        mDownloadPresenter = new DownloadPresenter(this);
        //view init

        findViewById(R.id.downloadBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean fastClick = Utils.isFastClick();
                Log.e("dddddddddddddd"," fastClidst" + fastClick);
              //  mDownloadPresenter.next(MVPActivity.this);;
            }
        });
        button = findViewById(R.id.downloadBtn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mDownloadPresenter.download("开始下载");
            }
        });

        progressDialog = new ProgressDialog(mContext);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                progressDialog.dismiss();
            }
        });
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setTitle("下载文件");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    @Override
    public void setProcessProgress(int progress) {
        progressDialog.setProgress(progress);

    }

    @Override
    public void setView(final String result) {
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               button.setText(result);
           }
       });
    }

    @Override
    public void showFailToast() {
        Toast.makeText(mContext, "Download fail !", Toast.LENGTH_SHORT).show();
    }
}
