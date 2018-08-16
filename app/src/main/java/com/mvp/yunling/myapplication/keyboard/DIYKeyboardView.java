package com.mvp.yunling.myapplication.keyboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

import com.mvp.yunling.myapplication.R;
import com.mvp.yunling.myapplication.keyboard.utils.CommonUtils;

import java.util.List;

/**
 * Created by pengchengfu on 2018/3/12.
 */

public class DIYKeyboardView extends KeyboardView {


    public DIYKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DIYKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Keyboard keyboard = getKeyboard();
        if (keyboard == null) return;
        List<Keyboard.Key> keys = keyboard.getKeys();
        if (keys != null && keys.size() > 0) {
            Paint paint = new Paint();
            paint.setTextAlign(Paint.Align.CENTER);
            Typeface font = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD);
            paint.setTypeface(font);
            paint.setAntiAlias(true);
            for (Keyboard.Key key : keys) {
                Drawable dr;
                if (key.codes[0] == -4) {
                    dr = getContext().getResources().getDrawable(R.drawable.keyboard_white);
                    dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                    dr.draw(canvas);
                } else if (key.codes[0]==-3){

                } else if (key.codes[0]==-5){
                  /*  dr = getContext().getResources().getDrawable(R.mipmap.jpush_ic_richpush_actionbar_back);
                    dr.setBounds(key.x/2, key.y+10, (key.x + key.width)/2, (key.y + key.height)+10);
                    dr.draw(canvas);*/
                }else {
                    dr = getContext().getResources().getDrawable(R.drawable.keyboard_white);
                    dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                    dr.draw(canvas);
                }
                if (key.label != null) {
                    if (key.codes[0] == -4 ||
                            key.codes[0] == -5) {
                        paint.setTextSize(CommonUtils.dip2px(getContext(),24));
                    } else {
                        paint.setTextSize(CommonUtils.dip2px(getContext(),22));
                    }
                    if (key.codes[0] == -4) {
                        paint.setColor(Color.GRAY);
                    } else {
                        paint.setColor(getContext().getResources().getColor(R.color.gray_5F5D5D));
                    }
                    Rect rect = new Rect(key.x, key.y, key.x + key.width, key.y + key.height);
                    Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
                    int baseline = (rect.bottom + rect.top - fontMetrics.bottom - fontMetrics.top) / 2;
                    // 下面这行是实现水平居中，drawText对应改为传入targetRect.centerX()
                    paint.setTextAlign(Paint.Align.CENTER);
                    if (key.codes[0]==-4){
                        canvas.drawText("搜",rect.centerX(),rect.centerY()-CommonUtils.dip2px(getContext(),15),paint);
                        canvas.drawText("索",rect.centerX(),rect.centerY()+CommonUtils.dip2px(getContext(),15),paint);
                    }else {
                        canvas.drawText(key.label.toString(), rect.centerX(), baseline, paint);
                    }

                }
            }
        }
    }
}