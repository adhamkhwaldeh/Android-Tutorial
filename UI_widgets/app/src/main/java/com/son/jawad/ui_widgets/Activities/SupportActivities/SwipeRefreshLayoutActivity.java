package com.son.jawad.ui_widgets.Activities.SupportActivities;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-08-29.
 */

public class SwipeRefreshLayoutActivity extends AppCompatActivity {

    public SwipeRefreshLayout swiperefreshlayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swiperefreshlayout_layout);
        swiperefreshlayout = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout);

        swiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swiperefreshlayout.setRefreshing(false);
                    }
                }, 1000);

            }
        });
    }
}
