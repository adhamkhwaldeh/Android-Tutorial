package com.son.jawad.ui_widgets.Activities.ServicesActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-09-12.
 */

public class ServicesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services_layout);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.unbindservicebtn:
                startActivity(new Intent(ServicesActivity.this, ServiceUnBindActivity.class));
                break;
            case R.id.bindservicebtn:
                startActivity(new Intent(ServicesActivity.this, ServiceBindActivity.class));
                break;
            case R.id.intentservicebtn:
                startActivity(new Intent(ServicesActivity.this, IntentServiceActivity.class));
                break;
        }
    }
}
