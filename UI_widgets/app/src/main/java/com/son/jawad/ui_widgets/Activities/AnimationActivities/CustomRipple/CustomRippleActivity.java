package com.son.jawad.ui_widgets.Activities.AnimationActivities.CustomRipple;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-10-07.
 */

public class CustomRippleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customripple_layout);
    }

    public void onclickbtn(View view) {
        switch (view.getId()) {
            case R.id.backgroundripplebtn:
                startActivity(new Intent(CustomRippleActivity.this, RippleBackgroundActivity.class));
                break;
            case R.id.materialripplebtn:
                startActivity(new Intent(CustomRippleActivity.this, MaterialRippleActivity.class));
                break;

        }
    }
}
