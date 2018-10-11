package com.mvp.yunling.myapplication.basisfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mvp.yunling.myapplication.R;
import com.mvp.yunling.myapplication.base.BaseFragment;

import me.yokeyword.swipebackfragment.SwipeBackFragment;

/**
 *n  Created by yunling on 2018/8/30.
 */

public class TestTwoFragment extends BaseFragment {
    public  static String ARG_POSITION;
    View view;
    Button button;
    @Override
    public void onAttach(Context context) {
        Log.e("onAttach","TestTwoFragment");
        super.onAttach(context);
    }
    public static TestTwoFragment newInstance() {

        Bundle args = new Bundle();

        TestTwoFragment fragment = new TestTwoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.article_view2, container, false);
        button = view.findViewById(R.id.button4);
        initview();
        return attachToSwipeBack(view);
    }

    private void initview() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAddFragmentListener != null) {
                    mAddFragmentListener.onAddFragment(TestTwoFragment.this, TestThreeFragment.newInstance());
                }
            }
        });
    }
    @Override
    public void onStart() {
        Log.e("onStart","TestTwoFragment");
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.e("onStop","TestTwoFragment");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e("onDestroyView","TestTwoFragment");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("onDestroy","TestTwoFragment");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e("onDetach","TestTwoFragment");
        super.onDetach();
    }
}
