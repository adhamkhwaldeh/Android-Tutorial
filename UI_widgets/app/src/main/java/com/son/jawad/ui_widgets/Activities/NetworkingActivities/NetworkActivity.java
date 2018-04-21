package com.son.jawad.ui_widgets.Activities.NetworkingActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.ui_widgets.Activities.NetworkingActivities.Retrofit.RetrofitActivity;
import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-08-31.
 */

public class NetworkActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.network_layout);
    }

    public void onclickbtn(View view) {
        switch (view.getId()) {
            case R.id.HttpUrlConnectionbtn:
                startActivity(new Intent(NetworkActivity.this, HttpUrlConnectionActivity.class));
                break;
            case R.id.Volleybtn:
                startActivity(new Intent(NetworkActivity.this, VolleyActivity.class));
                break;
            case R.id.Retrofitbtn:
                startActivity(new Intent(NetworkActivity.this, RetrofitActivity.class));
                break;
        }
    }
}
