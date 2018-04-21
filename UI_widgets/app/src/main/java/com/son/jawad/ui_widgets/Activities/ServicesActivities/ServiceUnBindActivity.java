package com.son.jawad.ui_widgets.Activities.ServicesActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.son.jawad.ui_widgets.Activities.ServicesActivities.Services.MyUnBindService;

/**
 * Created by Adhamkh on 2017-09-12.
 */

public class ServiceUnBindActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(ServiceUnBindActivity.this, MyUnBindService.class));

    }

    @Override
    protected void onPause() {
        super.onPause();
        boolean b = stopService(new Intent(ServiceUnBindActivity.this, MyUnBindService.class));
        Log.v("", "");
    }
}
