package com.son.jawad.ui_widgets.Activities.AnimationActivities.BaseActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-10-06.
 */

public class PreAnimatorActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preanimator_layout);
    }
}
