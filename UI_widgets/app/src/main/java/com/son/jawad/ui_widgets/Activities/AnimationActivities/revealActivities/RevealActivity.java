package com.son.jawad.ui_widgets.Activities.AnimationActivities.revealActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-10-07.
 */

public class RevealActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reveal_layout);
    }

    public void onclickbtn(View view) {
        switch (view.getId()) {
            case R.id.revealstanderdbtn:
                startActivity(new Intent(RevealActivity.this, StanderdRevealActivity.class));
                break;
            case R.id.revealcustombtn:
                startActivity(new Intent(RevealActivity.this, CustomRevealActivity.class));
                break;
        }
    }
}
