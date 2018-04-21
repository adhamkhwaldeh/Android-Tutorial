package com.son.jawad.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Adhamkh on 2017-08-15.
 */
public class ThirdActivity extends AppCompatActivity {

    TextView resulttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        resulttext = (TextView) findViewById(R.id.resulttext);
        Log.e("Create activity", this.getClass().getName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Start activity", this.getClass().getName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Resume activity", this.getClass().getName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Pause activity", this.getClass().getName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Stop activity", this.getClass().getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Destroy activity", this.getClass().getName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Restart activity", this.getClass().getName());
    }

    public void btnclick(View view) {
        startActivityForResult(new Intent(ThirdActivity.this, FourthActivity.class), 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            String res = data.getExtras().getString("MSG");
            resulttext.setText(res);
        } else {
            resulttext.setText("Cancel Operation");
        }
    }
}
