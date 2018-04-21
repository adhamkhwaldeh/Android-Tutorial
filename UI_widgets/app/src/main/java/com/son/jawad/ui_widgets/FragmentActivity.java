package com.son.jawad.ui_widgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.ui_widgets.Fragments.MainFragment;

/**
 * Created by Adhamkh on 2017-08-21.
 */

public class FragmentActivity extends AppCompatActivity {

    public View mainfragmentid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_layout);
        mainfragmentid = (View) findViewById(R.id.mainfragmentid);
        Fragment newFragment = MainFragment.newInstance();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainfragmentid, newFragment).commit();
    }

//    void addFragmentToStack() {
//        mStackLevel++;
//
//        // Instantiate a new fragment.
//        Fragment newFragment = CountingFragment.newInstance(mStackLevel);
//
//        // Add the fragment to the activity, pushing this transaction
//        // on to the back stack.
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.setCustomAnimations(R.animator.fragment_slide_left_enter,
//                R.animator.fragment_slide_left_exit,
//                R.animator.fragment_slide_right_enter,
//                R.animator.fragment_slide_right_exit);
//        ft.replace(R.id.simple_fragment, newFragment);
//        ft.addToBackStack(null);
//        ft.commit();
//    }

}
