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


/**
 *n  Created by yunling on 2018/8/30.
 */

public class TestFragment extends BaseFragment {

    private View view;
    private Button button;
    public static TestFragment newInstance() {

        Bundle args = new Bundle();

        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        Log.e("onAttach","TestFragment");
        super.onAttach(context);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("onCreateView","TestFragment oncreateView");
         view= inflater.inflate(R.layout.article_view, container, false);
        button = view.findViewById(R.id.button3);
        initview();
        return  attachToSwipeBack(view);
    }

    private void initview() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAddFragmentListener != null) {
                    mAddFragmentListener.onAddFragment(TestFragment.this, TestTwoFragment.newInstance());
                }

            }
        });
    }

    @Override
    public void onStart() {
        Log.e("onStart","TestFragment");
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.e("onStop","TestFragment");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e("onDestroyView","TestFragment");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("onDestroy","TestFragment");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e("onDetach","TestFragment");
        super.onDetach();
    }
}
