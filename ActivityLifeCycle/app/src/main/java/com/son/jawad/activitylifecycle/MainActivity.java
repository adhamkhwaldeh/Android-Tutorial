package com.son.jawad.activitylifecycle;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_layout);
        Log.e("Create activity",this.getClass().getName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Start activity",this.getClass().getName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Resume activity",this.getClass().getName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Pause activity",this.getClass().getName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Stop activity",this.getClass().getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Destroy activity",this.getClass().getName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Restart activity",this.getClass().getName());
    }

    public void btnclick(View view) {
        startActivity(new Intent(MainActivity.this,SecondActivity.class));
    }

}
