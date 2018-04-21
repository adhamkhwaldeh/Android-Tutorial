package com.son.jawad.ui_widgets.Activities.DesignPatternActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-09-17.
 */

public class DesignPatternActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.designpattern_layout);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.DataBingbtn:
                startActivity(new Intent(DesignPatternActivity.this, DataBingingActivity.class));
                break;
            case R.id.CodeInjectionbtn:
                startActivity(new Intent(DesignPatternActivity.this, CodeInjectionActivity.class));
                break;
            case R.id.mvpbtn:
                startActivity(new Intent(DesignPatternActivity.this, MVPActivity.class));
                break;
        }
    }

}
