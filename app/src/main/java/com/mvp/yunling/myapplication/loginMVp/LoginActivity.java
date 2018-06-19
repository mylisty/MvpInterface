package com.mvp.yunling.myapplication.loginMVp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mvp.yunling.myapplication.R;

import org.w3c.dom.Text;

/**
 * Created by yunling on 2018/6/7.
 */

public class LoginActivity extends AppCompatActivity implements IDLoginView {

    private EditText editText;
    private TextView textView;
    private Button button;
    private LoginPreseners loginPreseners;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        init();
    }

    private void init() {
        loginPreseners = new LoginPreseners(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = editText.getText().toString().trim();

                loginPreseners.login(trim);
            }
        });

    }

    @Override
    public void success(String bean) {
        textView.setText(bean);
        Toast.makeText(this, bean, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fail(String reason) {
        textView.setText(reason);
        Toast.makeText(this, reason, Toast.LENGTH_SHORT).show();
    }
}
