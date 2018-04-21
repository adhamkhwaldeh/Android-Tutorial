package com.son.jawad.ui_widgets.Activities.SupportActivities.TabLayoutActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-09-02.
 */

public class TabLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout_layout);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.standerdtablayoutbtn:
                startActivity(new Intent(TabLayoutActivity.this, StanderdTabLayoutActivity.class));
                break;
            case R.id.Customtablayoutbtn:
                startActivity(new Intent(TabLayoutActivity.this, CustomTabLayoutActivity.class));
                break;
        }
    }
}
