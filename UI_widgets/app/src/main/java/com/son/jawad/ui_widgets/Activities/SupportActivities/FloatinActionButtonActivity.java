package com.son.jawad.ui_widgets.Activities.SupportActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.son.jawad.tutoriallibrary.FloatingActionButton.FloatingActionButton;
import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-08-30.
 */

public class FloatinActionButtonActivity extends AppCompatActivity {

    public FloatingActionButton fab_plus, fab_favorite, fab_buynow, fab_addcart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floatingactionbutton_layout);
        initfab();
    }


    public void initfab() {
        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_favorite = (FloatingActionButton) findViewById(R.id.fab_favorite);
        fab_buynow = (FloatingActionButton) findViewById(R.id.fab_buynow);
        fab_addcart = (FloatingActionButton) findViewById(R.id.fab_addcart);

        final Animation open, close, clockwise, anclockwise;
        open = AnimationUtils.loadAnimation(FloatinActionButtonActivity.this, R.anim.fab_open);
        close = AnimationUtils.loadAnimation(FloatinActionButtonActivity.this, R.anim.fab_close);
        clockwise = AnimationUtils.loadAnimation(FloatinActionButtonActivity.this, R.anim.rotate_clockwise);
        anclockwise = AnimationUtils.loadAnimation(FloatinActionButtonActivity.this, R.anim.rotate_anticlockwise);
        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fab_favorite.getVisibility() == View.VISIBLE) {
                    fab_plus.setAnimation(anclockwise);
                    fab_favorite.setAnimation(close);
                    fab_buynow.setAnimation(close);
                    fab_addcart.setAnimation(close);
                    fab_favorite.setVisibility(View.INVISIBLE);
                    fab_buynow.setVisibility(View.INVISIBLE);
                    fab_addcart.setVisibility(View.INVISIBLE);
                    fab_favorite.setClickable(false);
                    fab_buynow.setClickable(false);
                    fab_addcart.setClickable(false);
                } else {
                    fab_plus.setAnimation(clockwise);
                    fab_favorite.setAnimation(open);
                    fab_buynow.setAnimation(open);
                    fab_addcart.setAnimation(open);
                    fab_favorite.setVisibility(View.VISIBLE);
                    fab_buynow.setVisibility(View.VISIBLE);
                    fab_addcart.setVisibility(View.VISIBLE);
                    fab_favorite.setClickable(true);
                    fab_buynow.setClickable(true);
                    fab_addcart.setClickable(true);
                }
            }
        });
    }


}
