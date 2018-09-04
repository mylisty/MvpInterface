package com.mvp.yunling.myapplication.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import me.yokeyword.swipebackfragment.SwipeBackFragment;
import me.yokeyword.swipebackfragment.SwipeBackLayout;

/**
 * Created by yunling on 2018/9/4.
 */

public class BaseFragment  extends SwipeBackFragment{
    protected OnAddFragmentListener mAddFragmentListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAddFragmentListener) {
            mAddFragmentListener = (OnAddFragmentListener) context;
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// 设置侧滑触摸生效区域 MAX,MED,MIN,custom
        setEdgeLevel(SwipeBackLayout.EdgeLevel.MAX);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mAddFragmentListener = null;
    }

    public interface OnAddFragmentListener {
        void onAddFragment(Fragment fromFragment, Fragment toFragment);
    }
}
