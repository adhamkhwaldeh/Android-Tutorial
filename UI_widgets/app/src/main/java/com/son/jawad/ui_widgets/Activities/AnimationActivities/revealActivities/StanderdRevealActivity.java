package com.son.jawad.ui_widgets.Activities.AnimationActivities.revealActivities;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-10-07.
 */

public class StanderdRevealActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standerdreveal_layout);
        final View shape = findViewById(R.id.circle);
        final View button = findViewById(R.id.button);
        // Set a listener to reveal the view when clicked.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a reveal {@link Animator} that starts clipping the view from
                // the top left corner until the whole view is covered.
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(
                        shape,
                        0,
                        0,
                        0,
                        (float) Math.hypot(shape.getWidth(), shape.getHeight()));
                circularReveal.setInterpolator(new AccelerateDecelerateInterpolator());
                circularReveal.setDuration(1000);
                // Finally start the animation
                circularReveal.start();
            }
        });
    }


}
