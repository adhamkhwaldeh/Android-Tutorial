package com.son.jawad.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Adhamkh on 2017-08-15.
 */

public class FourthActivity extends AppCompatActivity {

    Button Okbtn, Cancelbtn;
    EditText messageedittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_layout);
        Okbtn = (Button) findViewById(R.id.Okbtn);
        Cancelbtn = (Button) findViewById(R.id.Cancelbtn);
        messageedittext = (EditText) findViewById(R.id.messageedittext);

        Okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("MSG", messageedittext.getText().toString());
                setResult(1, intent);
                finish();
            }
        });

        Cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("MSG", messageedittext.getText().toString());
                setResult(0, intent);
                finish();
            }
        });

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
}
