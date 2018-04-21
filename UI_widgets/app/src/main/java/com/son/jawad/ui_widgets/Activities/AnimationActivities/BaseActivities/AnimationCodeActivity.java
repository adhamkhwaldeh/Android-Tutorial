package com.son.jawad.ui_widgets.Activities.AnimationActivities.BaseActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-10-06.
 */

public class AnimationCodeActivity extends AppCompatActivity {

    Button btnFadeIn, btnFadeOut, btnCrossFade, btnBlink, btnZoomIn,
            btnZoomOut, btnRotate, btnMove, btnSlideUp, btnSlideDown,
            btnBounce, btnSequential, btnTogether;

    TextView txtFadeIn, txtFadeOut, txtBlink, txtZoomIn, txtZoomOut, txtRotate, txtMove, txtSlideUp,
            txtSlideDown, txtBounce, txtSeq, txtTog, txtIn, txtOut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animationcode_layout);
        btnFadeIn = (Button) findViewById(R.id.btnFadeIn);
        btnFadeOut = (Button) findViewById(R.id.btnFadeOut);
        btnCrossFade = (Button) findViewById(R.id.btnCrossFade);
        btnBlink = (Button) findViewById(R.id.btnBlink);
        btnZoomIn = (Button) findViewById(R.id.btnZoomIn);
        btnZoomOut = (Button) findViewById(R.id.btnZoomOut);
        btnRotate = (Button) findViewById(R.id.btnRotate);
        btnMove = (Button) findViewById(R.id.btnMove);
        btnSlideUp = (Button) findViewById(R.id.btnSlideUp);
        btnSlideDown = (Button) findViewById(R.id.btnSlideDown);
        btnBounce = (Button) findViewById(R.id.btnBounce);
        btnSequential = (Button) findViewById(R.id.btnSequential);
        btnTogether = (Button) findViewById(R.id.btnTogether);
        txtFadeIn = (TextView) findViewById(R.id.txt_fade_in);
        txtFadeOut = (TextView) findViewById(R.id.txt_fade_out);
        txtBlink = (TextView) findViewById(R.id.txt_blink);
        txtZoomIn = (TextView) findViewById(R.id.txt_zoom_in);
        txtZoomOut = (TextView) findViewById(R.id.txt_zoom_out);
        txtRotate = (TextView) findViewById(R.id.txt_rotate);
        txtMove = (TextView) findViewById(R.id.txt_move);
        txtSlideUp = (TextView) findViewById(R.id.txt_slide_up);
        txtSlideDown = (TextView) findViewById(R.id.txt_slide_down);
        txtBounce = (TextView) findViewById(R.id.txt_bounce);
        txtSeq = (TextView) findViewById(R.id.txt_seq);
        txtTog = (TextView) findViewById(R.id.txt_tog);
        txtIn = (TextView) findViewById(R.id.txt_in);
        txtOut = (TextView) findViewById(R.id.txt_out);


		/*
         * Buttons click events
		 */
        // fade in
        btnFadeIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //  txtFadeIn.setVisibility(View.VISIBLE);
                txtFadeIn.setAlpha(0.0f);

                txtFadeIn.animate().alphaBy(0.0f).alpha(1.0f).setInterpolator(new AccelerateInterpolator())
                        .setDuration(1000).start();
            }
        });

        // fade out
        btnFadeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // txtFadeOut.setVisibility(View.VISIBLE);
                txtFadeOut.animate().alphaBy(1.0f).alpha(0.0f).setInterpolator(new AccelerateInterpolator())
                        .setDuration(1000).start();
            }
        });

        // cross fade
        btnCrossFade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtOut.setVisibility(View.VISIBLE);
                // start fade in animation
                txtOut.animate().alphaBy(0.0f).alpha(1.0f).setInterpolator(new AccelerateInterpolator())
                        .setDuration(1000).start();

                // start fade out animation
                txtIn.animate().alphaBy(1.0f).alpha(0.0f).setInterpolator(new AccelerateInterpolator())
                        .setDuration(1000).start();
            }
        });

        // blink
        btnBlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtBlink.setVisibility(View.VISIBLE);

                Animation animation = new AlphaAnimation(1.0f, 0.0f);
                // animation.setStartOffset(0);
                animation.setFillAfter(true);
                animation.setRepeatMode(Animation.REVERSE);
                animation.setRepeatCount(Animation.INFINITE);
                animation.setDuration(600);
                animation.setInterpolator(new AccelerateInterpolator());
                txtBlink.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.v("", "");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.v("", "");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.v("", "");
                    }
                });


            }
        });

        // Zoom In
        btnZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtZoomIn.setVisibility(View.VISIBLE);
                Animation animation = new ScaleAnimation(1, 3, 1, 3);
                animation.setDuration(1000);
                txtZoomIn.setPivotX(50);
                txtZoomIn.setPivotY(50);
//                txtZoomIn.setPivotX(0);
//                txtZoomIn.setPivotY(0);
                txtZoomIn.startAnimation(animation);
            }
        });

        // Zoom Out
        btnZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtZoomOut.setVisibility(View.VISIBLE);
                txtZoomOut.setVisibility(View.VISIBLE);
                Animation animation = new ScaleAnimation(1, 0.5f, 1, 0.5f);
                animation.setDuration(1000);
                txtZoomOut.setPivotX(50);
                txtZoomOut.setPivotY(50);
//                txtZoomIn.setPivotX(0);
//                txtZoomIn.setPivotY(0);
                txtZoomOut.startAnimation(animation);
            }
        });

        // Rotate
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RotateAnimation animRotate = new RotateAnimation(0, 360);
                animRotate.setDuration(600);
                animRotate.setRepeatCount(Animation.INFINITE);
                animRotate.setRepeatMode(Animation.RESTART);
                animRotate.setInterpolator(new CycleInterpolator(1));
                txtRotate.startAnimation(animRotate);
            }
        });

        // Move
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAnimation animMove = new TranslateAnimation(txtMove.getX(), getWindowManager().getDefaultDisplay().getWidth(), 0, 0);
                animMove.setDuration(800);
                txtMove.startAnimation(animMove);
            }
        });
        // Slide Up
        btnSlideUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScaleAnimation animSlideUp = new ScaleAnimation(1, 1, 1, 0);
                animSlideUp.setDuration(500);
                animSlideUp.setInterpolator(new LinearInterpolator());
                txtSlideUp.startAnimation(animSlideUp);
            }
        });

        // Slide Down
        btnSlideDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animSlideDown = new ScaleAnimation(1, 0, 1, 1);
                animSlideDown.setDuration(500);
                txtSlideDown.startAnimation(animSlideDown);
            }
        });

        // Slide Down
        btnBounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScaleAnimation animBounce = new ScaleAnimation(1, 0, 1, 1);
                animBounce.setDuration(500);
                txtBounce.startAnimation(animBounce);
            }
        });

//        animSequential = AnimationUtils.loadAnimation(getApplicationContext(),
//                R.anim.sequential);
        // Sequential
        btnSequential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AnimationSet animSequential = new AnimationSet();
//                txtSeq.startAnimation(animSequential);
            }
        });

        // Together
        btnTogether.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AnimationSet animTogether = new AnimationSet(true);

                ScaleAnimation scaleAnimation = new ScaleAnimation(1, 4, 1, 4);
                scaleAnimation.setDuration(4000);
                scaleAnimation.setRepeatCount(Animation.INFINITE);
                scaleAnimation.setRepeatMode(Animation.REVERSE);

                RotateAnimation rotateAnimation = new RotateAnimation(0, 360);
                rotateAnimation.setDuration(500);
                rotateAnimation.setRepeatCount(Animation.INFINITE);
                rotateAnimation.setRepeatMode(Animation.REVERSE);


                animTogether.addAnimation(scaleAnimation);
                animTogether.addAnimation(rotateAnimation);
                txtTog.startAnimation(animTogether);
            }
        });

    }
}
