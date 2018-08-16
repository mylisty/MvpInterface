package com.mvp.yunling.myapplication.keyboard;

import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.mvp.yunling.myapplication.R;
import com.mvp.yunling.myapplication.keyboard.utils.KeyBoardUtil;

public class KeyboardActivity extends AppCompatActivity {

    private EditText mInput;
    private KeyboardView mKeyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keybroad);
        initView();
        initEvent();
    }

    private void initView() {
        mKeyboard = findViewById(R.id.ky_keyboard);
        mInput = findViewById(R.id.et_input);
    }

    private void initEvent() {
        final  KeyBoardUtil keyBoardUtil = new KeyBoardUtil(mKeyboard, mInput);
        mInput.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(mInput.hasFocus()){
                    keyBoardUtil.showKeyboard();
                    keyBoardUtil.setOnKeyboardListener(new KeyBoardUtil.OnKeyboardListener() {
                        @Override
                        public void onHide(boolean isCompleted) {

                        }

                        @Override
                        public void onShow() {

                        }

                        @Override
                        public void onPress(int primaryCode) {
                        }
                    });
                }
                return false;
            }
        });
    }
}
