package com.mvp.yunling.myapplication.basisfragment;

import android.content.Context;
import android.content.Intent;
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

public class TestThreeFragment extends BaseFragment {
    public  static String ARG_POSITION;
    View view;
    Button button;

    public static TestThreeFragment newInstance() {

        Bundle args = new Bundle();

        TestThreeFragment fragment = new TestThreeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(Context context) {
        Log.e("onAttach","TestThreeFragment");
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.article_view2, container, false);
        button = view.findViewById(R.id.button4);
        button.setText("button5");
        initview();
        return  attachToSwipeBack(view);
    }

    private void initview() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }
    @Override
    public void onStart() {
        Log.e("onStart","TestThreeFragment");
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.e("onStop","TestThreeFragment");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e("onDestroyView","TestThreeFragment");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("onDestroy","TestThreeFragment");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e("onDetach","TestThreeFragment");
        super.onDetach();
    }


}
