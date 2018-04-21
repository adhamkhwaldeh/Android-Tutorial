package com.son.jawad.ui_widgets.Activities.UIActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.son.jawad.ui_widgets.R;


/**
 * Created by Adhamkh on 2017-08-20.
 */

public class LayoutsActivity extends AppCompatActivity implements View.OnClickListener {

    public Button Relativebtn;
    public Button frame_layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_layout);
        Relativebtn = (Button) findViewById(R.id.relative_layout);
        frame_layout = (Button) findViewById(R.id.frame_layout);
        frame_layout.setOnClickListener(this);
        Relativebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LayoutsActivity.this, RelativeActivity.class));
            }
        });
    }

    public void onclickbtn(View view) {
        switch (view.getId()) {
            case R.id.relative_layout:
                // startActivity(new Intent(LayoutsActivity.this, RelativeActivity.class));
                break;
            case R.id.table_layout:
                startActivity(new Intent(LayoutsActivity.this, TableActivity.class));
                break;
            case R.id.frame_layout:

                break;
        }
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(LayoutsActivity.this, FrameActivity.class));
    }
}
