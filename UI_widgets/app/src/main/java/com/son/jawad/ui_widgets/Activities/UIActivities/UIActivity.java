package com.son.jawad.ui_widgets.Activities.UIActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.son.jawad.ui_widgets.R;

public class UIActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_layout);

    }

    public void onclickbtn(View view) {
        switch (view.getId()) {
            case R.id.layoutbtn:
                startActivity(new Intent(UIActivity.this, LayoutsActivity.class));
                break;
            case R.id.spinnerbtn:
                startActivity(new Intent(UIActivity.this, SpinnerActivity.class));
                break;
            case R.id.autocompletebtn:
                startActivity(new Intent(UIActivity.this, AutoCompleteActivity.class));
                break;
            case R.id.ratingbtn:
                startActivity(new Intent(UIActivity.this, RatingActivity.class));
                break;
            case R.id.webviewbtn:
                startActivity(new Intent(UIActivity.this, WebviewActivity.class));
                break;
            case R.id.seekbarbtn:
                startActivity(new Intent(UIActivity.this, SeekBarActivity.class));
                break;
            case R.id.datetimepickertn:
                startActivity(new Intent(UIActivity.this, DateTimeActivity.class));
                break;
            case R.id.menusbtn:
                startActivity(new Intent(UIActivity.this, MenuActivity.class));
                break;
            case R.id.buttongroups:
                startActivity(new Intent(UIActivity.this, ButtonActivity.class));
                break;
            case R.id.custombtn:
                startActivity(new Intent(UIActivity.this, CustomActivity.class));
                break;
        }
    }

}
