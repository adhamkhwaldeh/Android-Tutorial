package com.son.jawad.ui_widgets.Activities.AnimationActivities.CustomRipple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.son.jawad.tutoriallibrary.AnimationViews.Ripples.RippleView;
import com.son.jawad.ui_widgets.R;

import java.util.ArrayList;


public class ReppleEffectActivity extends AppCompatActivity {
    private final Boolean isRecyclerview = false;
    private ArrayList<String> sourcesArrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reppleeffect_layout);

        final RippleView rippleView = (RippleView) findViewById(R.id.rect);
        final TextView textView = (TextView) findViewById(R.id.rect_child);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.actionbar);

        setSupportActionBar(toolbar);

        rippleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Sample", "Click Rect !");
            }
        });
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Log.d("Sample", "Ripple completed");
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Sample", "Click rect child !");
            }
        });

        sourcesArrayList.add("Samsung");
        sourcesArrayList.add("Android");
        sourcesArrayList.add("Google");
        sourcesArrayList.add("Asus");
        sourcesArrayList.add("Apple");
        sourcesArrayList.add("Samsung");
        sourcesArrayList.add("Android");
        sourcesArrayList.add("Google");
        sourcesArrayList.add("Asus");
        sourcesArrayList.add("Apple");
        sourcesArrayList.add("Samsung");
        sourcesArrayList.add("Android");
        sourcesArrayList.add("Google");
        sourcesArrayList.add("Asus");
        sourcesArrayList.add("Apple");

    }

}
