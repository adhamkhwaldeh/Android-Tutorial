package com.son.jawad.ui_widgets.Activities.SupportActivities.CoordinateLayoutActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-08-30.
 */

public class CoordinateLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinatelayout_layout);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.coordinatestanderdbtn:
                startActivity(new Intent(CoordinateLayoutActivity.this, CoordinateStanderdActivity.class));
                break;
            case R.id.coordinatecollapsebtn:
                startActivity(new Intent(CoordinateLayoutActivity.this, CoordinateCollapseActivity.class));
                break;
            case R.id.BottomSheetBehaviorbtn:
                startActivity(new Intent(CoordinateLayoutActivity.this, BottomSheetBehaviorActivity.class));
                break;
            case R.id.CustomCoordinateBehaviorbtn:
                startActivity(new Intent(CoordinateLayoutActivity.this, CustomCoordinatelayoutActivity.class));
                break;
            case R.id.CustomCoordinateGmailBehaviorbtn:
                startActivity(new Intent(CoordinateLayoutActivity.this, GmailStyleActivity.class));
                break;
        }
    }
}
