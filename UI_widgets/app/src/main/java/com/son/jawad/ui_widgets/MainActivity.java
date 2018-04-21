package com.son.jawad.ui_widgets;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.ui_widgets.Activities.AnimationActivities.AnimationMainActivity;
import com.son.jawad.ui_widgets.Activities.DesignPatternActivities.DesignPatternActivity;
import com.son.jawad.ui_widgets.Activities.ImageLoaderActivities.ImageLoaderActivity;
import com.son.jawad.ui_widgets.Activities.NetworkingActivities.NetworkActivity;
import com.son.jawad.ui_widgets.Activities.ProviderActivities.ProviderActivity;
import com.son.jawad.ui_widgets.Activities.ServicesActivities.ServicesActivity;
import com.son.jawad.ui_widgets.Activities.StorageActivities.StorageActivity;
import com.son.jawad.ui_widgets.Activities.SupportActivities.SupportLibraryActivity;
import com.son.jawad.ui_widgets.Activities.UIActivities.UIActivity;

/**
 * Created by Adhamkh on 2017-08-18. hello
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }

    public void onclickbtn(View view) {
        switch (view.getId()) {
            case R.id.UIbtn:
                startActivity(new Intent(MainActivity.this, UIActivity.class));
                break;
            case R.id.fragmentbtn:
                startActivity(new Intent(MainActivity.this, FragmentActivity.class));
                break;
            case R.id.supportbtn:
                startActivity(new Intent(MainActivity.this, SupportLibraryActivity.class));
                break;
            case R.id.intentbtn:
                startActivity(new Intent(MainActivity.this, IntentActivity.class));
                break;
            case R.id.networkingbtn:
                startActivity(new Intent(MainActivity.this, NetworkActivity.class));
                break;
            case R.id.ImagerLaoderbtn:
                startActivity(new Intent(MainActivity.this, ImageLoaderActivity.class));
                break;
            case R.id.servicebtn:
                startActivity(new Intent(MainActivity.this, ServicesActivity.class));
                break;
            case R.id.providerbtn:
                startActivity(new Intent(MainActivity.this, ProviderActivity.class));
                break;
            case R.id.storagebtn:
                startActivity(new Intent(MainActivity.this, StorageActivity.class));
                break;
            case R.id.designpattern:
                startActivity(new Intent(MainActivity.this, DesignPatternActivity.class));
                break;
            case R.id.animationbtn:
                startActivity(new Intent(MainActivity.this, AnimationMainActivity.class));
                break;
        }
    }
}
