package com.mvp.yunling.myapplication.keyboard.utils;

import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import com.mvp.yunling.myapplication.R;

import java.lang.reflect.Method;

/**
 * Created by pengchengfu on 2018/03/12
 */
public class KeyBoardUtil {

    private KeyboardView keyboardView;
    private EditText editText;
    private Keyboard keyboard;// 键盘

    public KeyBoardUtil(KeyboardView keyboardView, EditText editText) {
        this.keyboardView = keyboardView;
        this.editText = editText;
        editText.setCursorVisible(true);
        this.keyboard = new Keyboard(editText.getContext(), R.xml.key);
        try {
            Class<EditText> cls = EditText.class;
            Method setShowSoftInputOnFocus;
            setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus",
                    boolean.class);
            setShowSoftInputOnFocus.setAccessible(true);
            setShowSoftInputOnFocus.invoke(editText, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.keyboardView.setOnKeyboardActionListener(listener);
        this.keyboardView.setKeyboard(keyboard);
        //this.keyboardView.setEnabled(true);
        this.keyboardView.setPreviewEnabled(false);
    }

    private KeyboardView.OnKeyboardActionListener listener = new KeyboardView.OnKeyboardActionListener() {

        @Override
        public void swipeUp() {
        }

        @Override
        public void swipeRight() {

        }

        @Override
        public void swipeLeft() {
        }

        @Override
        public void swipeDown() {
        }

        @Override
        public void onText(CharSequence text) {
        }

        @Override
        public void onRelease(int primaryCode) {
        }

        @Override
        public void onPress(int primaryCode) {
        }

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {
            Editable editable = editText.getText();
            int start = editText.getSelectionStart();
            editText.setSelection(editable.toString().trim().length());
            editText.setCursorVisible(true);
            Log.e("aaaaaaaaaaaaaaaaaaaae","primaryCode  "+primaryCode);
            switch (primaryCode) {
                case Keyboard.KEYCODE_DELETE:
                    if (editable != null && editable.length() > 0) {
                        if (start > 0) {
                            editable.delete(start - 1, start);
                        }
                    }
                    break;
                case Keyboard.KEYCODE_DONE:
                   if (onKeyboardListener!=null){
                       onKeyboardListener.onPress(Keyboard.KEYCODE_DONE);
                   }
                       keyboardView.setVisibility(View.GONE);
                    break;
                case Keyboard.KEYCODE_CANCEL:
                    hideKeyboard();
                    break;
                default:
                    editable.insert(start, Character.toString((char) primaryCode));
                    break;
            }
        }
    };

    // Activity中获取焦点时调用，显示出键盘
    public void showKeyboard() {
        int visibility = keyboardView.getVisibility();
        if (visibility == View.GONE || visibility == View.INVISIBLE) {
            keyboardView.setVisibility(View.VISIBLE);
        }
    }

    // 隐藏键盘
    public void hideKeyboard() {
        int visibility = keyboardView.getVisibility();
        if (visibility == View.VISIBLE || visibility == View.INVISIBLE) {
            keyboardView.setVisibility(View.GONE);
        }
    }
    private OnKeyboardListener onKeyboardListener;
    public interface OnKeyboardListener {
        /**
         * 键盘隐藏了
         *
         * @param isCompleted true：表示点击了【完成】
         */
        void onHide(boolean isCompleted);

        /**
         * 键盘弹出了
         */
        void onShow();

        /**
         * 按下
         *
         * @param primaryCode
         */
        void onPress(int primaryCode);
    }

    /**
     * 对外开放的方法
     *
     * @param onKeyboardListener
     */
    public void setOnKeyboardListener(OnKeyboardListener onKeyboardListener) {
        this.onKeyboardListener = onKeyboardListener;
    }
}
