package com.son.jawad.ui_widgets.Activities.ServicesActivities;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.son.jawad.ui_widgets.Activities.ServicesActivities.Services.MyBindService;
import com.son.jawad.ui_widgets.Activities.ServicesActivities.Services.MyUnBindService;
import com.son.jawad.ui_widgets.Activities.ServicesActivities.Services.OnBindCallBackListener;
import com.son.jawad.ui_widgets.MainActivity;
import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-09-12.
 */

public class ServiceBindActivity extends AppCompatActivity implements ServiceConnection
        , OnBindCallBackListener {
    TextView badgebtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicebind_layout);
        badgebtn = (TextView) findViewById(R.id.badgebtn);
        Intent intent = new Intent(this, MyBindService.class);
        bindService(intent, this, Context.BIND_AUTO_CREATE);
        startService(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Intent intent = new Intent(this, MyBindService.class);
        //bindService(intent, this, Context.BIND_AUTO_CREATE);
        //startService(intent);
        // startService(new Intent(this, MyBindService.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        boolean b = stopService(new Intent(this, MyBindService.class));
        unbindService(this);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        MyBindService.MyBindServiceBinder myBindServiceBinder = (MyBindService.MyBindServiceBinder) service;
        MyBindService myBindService = myBindServiceBinder.getService();
        myBindService.setOnBindCallBackListener(ServiceBindActivity.this);
        myBindService.AsyncBadge();
        Log.v("", "");
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.v("", "");
    }

    @Override
    public void onbackBadge(String badge) {
        badgebtn.setText(badge);
        Log.v("", "");
    }

    public void onClick(View view) {
        startActivity(new Intent(ServiceBindActivity.this, MainActivity.class));
    }
}
