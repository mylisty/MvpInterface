package com.mvp.yunling.myapplication.daggermvp.daggerlogin;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mvp.yunling.myapplication.R;
import com.mvp.yunling.myapplication.daggermvp.base.BaseMvpActivity;

/**
 * Created by yunling on 2018/6/8.
 */

public class DaggerLoginActivity extends BaseMvpActivity<Login1Presenter> implements Login1Contract.ILoginView {

    private EditText editText;
    private TextView textView;
    private Button button;
    private ProgressDialog progressDialog;
    private boolean flag = true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        init();
        DaggerLoginComponent.
                builder().
                loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    private void init() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login();

            }
        });
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("加载中");
    }

    @Override
    public String getUserName() {
        return "账上";
    }

    @Override
    public String getPassword() {
        return editText.getText().toString().trim();
    }

    @Override
    public void clearUserName() {
    }

    @Override
    public void clearPassword() {
    }

    @Override
    public void showLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog.show();
            }
        });

    }

    @Override
    public void hideLoading() {
   runOnUiThread(new Runnable() {
       @Override
       public void run() {
           progressDialog.dismiss();
       }
   });

    }

    @Override
    public void next() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(DaggerLoginActivity.this, "success", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void showFailedError() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(DaggerLoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
