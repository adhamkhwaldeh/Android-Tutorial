package com.son.jawad.ui_widgets.Activities.AnimationActivities.revealActivities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

import com.son.jawad.tutoriallibrary.AnimationViews.Reveals.animation.ViewAnimationUtils;
import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-10-07.
 */

public class CustomRevealActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customreveal_layout);
    }

    public void onClick(View target) {
        // Cancel all concurrent events on view
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            target.cancelPendingInputEvents();
        }
        target.setEnabled(false);

        // Coordinates of circle initial point
        final ViewGroup parent = (ViewGroup) target.getParent();
        final Rect bounds = new Rect();
        final Rect maskBounds = new Rect();

        target.getDrawingRect(bounds);
        target.getDrawingRect(maskBounds);
        parent.offsetDescendantRectToMyCoords(target, bounds);
        parent.offsetDescendantRectToMyCoords(target, maskBounds);


        final int cX = maskBounds.centerX();
        final int cY = maskBounds.centerY();

        Animator circularReveal =
                ViewAnimationUtils.createCircularReveal(target, cX, cY, target.getWidth() / 2,
                        (float) Math.hypot(maskBounds.width() * .5f, maskBounds.height() * .5f),
                        View.LAYER_TYPE_HARDWARE);

        final float c0X = bounds.centerX() - maskBounds.centerX();
        final float c0Y = bounds.centerY() - maskBounds.centerY();

//        AnimatorPath path = new AnimatorPath();
//        path.moveTo(c0X, c0Y);
//        path.curveTo(c0X, c0Y, 0, c0Y, 0, 0);
//
//        ObjectAnimator pathAnimator = ObjectAnimator.ofObject(this, "maskLocation", new PathEvaluator(),
//                path.getPoints().toArray());

        AnimatorSet set = new AnimatorSet();
        set.play(circularReveal);
        //set.setInterpolator(new FastOutSlowInInterpolator());
        set.setInterpolator(new AccelerateInterpolator());
        set.setDuration(500);
        set.start();
    }

}
