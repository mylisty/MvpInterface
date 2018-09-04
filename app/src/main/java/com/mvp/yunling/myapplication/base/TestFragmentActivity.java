package com.mvp.yunling.myapplication.base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mvp.yunling.myapplication.R;
import com.mvp.yunling.myapplication.SharedPreferencesUtils;
import com.mvp.yunling.myapplication.basisfragment.TestFragment;
import com.mvp.yunling.myapplication.basisfragment.TestTwoFragment;

import me.yokeyword.swipebackfragment.SwipeBackActivity;

/**
 *  Created by yunling on 2018/8/30.
 */

public class TestFragmentActivity extends SwipeBackActivity implements BaseFragment.OnAddFragmentListener {

    private TestFragment firstFragment;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (savedInstanceState == null) {
                    TestFragment firstFragment = TestFragment.newInstance();
                    loadFragment(firstFragment);
                } else {
                    Toast.makeText(TestFragmentActivity.this, "啊哦,app被强杀喽,请重启骑士加油", Toast.LENGTH_LONG).show();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
      /*  if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            firstFragment = new TestFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Create fragment and give it an argument specifying the article it should show
                Bundle args = new Bundle();
                args.putInt("button", 2);
                firstFragment.setArguments(args);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.fragment_container, firstFragment);
                transaction.addToBackStack(null);

// Commit the transaction
                transaction.commit();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestTwoFragment newFragment = new TestTwoFragment();
                Bundle args = new Bundle();
                args.putInt(TestTwoFragment.ARG_POSITION, 2);
                newFragment.setArguments(args);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);

// Commit the transaction
                transaction.commit();
            }
        });*/
      /*  if (savedInstanceState == null) {
            TestFragment firstFragment = TestFragment.newInstance();
            loadFragment(firstFragment);
        } else {
            Toast.makeText(TestFragmentActivity.this, "啊哦,app被强杀喽,请重启骑士加油", Toast.LENGTH_LONG).show();
       }*/
       setSwipeBackEnable(false);
    }
    private void loadFragment(Fragment toFragment) {
        getSupportFragmentManager().beginTransaction()
                //.setCustomAnimations(R.anim.h_fragment_enter, R.anim.h_fragment_exit, R.anim.h_fragment_pop_enter, R.anim.h_fragment_pop_exit)
                .add(R.id.fragment_container, toFragment, toFragment.getClass().getSimpleName())
                .addToBackStack(toFragment.getClass().getSimpleName())
                .commit();
    }
    @Override
    public boolean swipeBackPriority() {
    //   return super.swipeBackPriority();
        // 下面是默认实现:
        return getSupportFragmentManager().getBackStackEntryCount() == 0;
    }
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

 /*   @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME) ) {
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }*/

    @Override
    public void onAddFragment(Fragment fromFragment, Fragment toFragment) {
        getSupportFragmentManager().beginTransaction()
             .setCustomAnimations(R.anim.h_fragment_enter, R.anim.h_fragment_exit, R.anim.h_fragment_pop_enter, R.anim.h_fragment_pop_exit)
                .add(R.id.fragment_container, toFragment, toFragment.getClass().getSimpleName())
                .hide(fromFragment)
                .addToBackStack(toFragment.getClass().getSimpleName())
                .commit();
    }
}
