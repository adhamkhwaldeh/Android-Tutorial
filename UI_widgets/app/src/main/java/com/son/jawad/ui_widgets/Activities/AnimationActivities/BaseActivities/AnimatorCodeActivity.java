package com.son.jawad.ui_widgets.Activities.AnimationActivities.BaseActivities;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.son.jawad.ui_widgets.R;

import java.util.List;
import java.util.Vector;

import static android.animation.ObjectAnimator.ofFloat;
import static android.animation.ValueAnimator.INFINITE;

/**
 * Created by Adhamkh on 2017-10-06.
 */

public class AnimatorCodeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animatorcode_layout);
    }

    public void onClick(final View view) {
        AnimatorSet animator = new AnimatorSet();
        List<Animator> animatorList = new Vector<>();
        switch (view.getId()) {
            case R.id.movebtn:
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "translationX", 0, 800);
                animator1.setRepeatCount(1);
                animator1.setRepeatMode(ValueAnimator.REVERSE);
                animator.setDuration(600);
                // animator1.start();
                animatorList.add(animator1);
                break;
            case R.id.scalebtn:
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "scaleX", 2);
                animator2.setRepeatCount(1);
                animator2.setRepeatMode(ValueAnimator.REVERSE);
                animator2.setDuration(600);

                ObjectAnimator animator3 = ObjectAnimator.ofFloat(view, "scaleY", 2);
                animator3.setRepeatCount(1);
                animator3.setRepeatMode(ValueAnimator.REVERSE);
                animator3.setDuration(600);

                animatorList.add(animator2);
                animatorList.add(animator3);

                break;
            case R.id.colorbtn:

                ObjectAnimator animator4 = ObjectAnimator.ofInt(view, "textColor", Color.GREEN, Color.RED);
                animator4.setRepeatCount(ValueAnimator.INFINITE);
                animator4.setRepeatMode(ValueAnimator.REVERSE);
                animator4.setEvaluator(new ArgbEvaluator());
                animator4.setDuration(6000);

                ObjectAnimator animator5 = ObjectAnimator.ofInt(view, "backgroundColor", Color.RED, Color.GREEN);
                animator5.setRepeatCount(ValueAnimator.INFINITE);
                animator5.setRepeatMode(ValueAnimator.REVERSE);
                animator5.setEvaluator(new ArgbEvaluator());
                animator5.setDuration(6000);

                ObjectAnimator animator6 = ObjectAnimator.ofInt(view, "padding", 0, 8);
                animator6.setRepeatCount(ValueAnimator.INFINITE);
                animator6.setRepeatMode(ValueAnimator.REVERSE);
                animator6.setEvaluator(new IntEvaluator());
                animator6.setDuration(6000);

                animatorList.add(animator4);
                animatorList.add(animator5);
                animatorList.add(animator6);
                break;
            case R.id.paddingbtn:
                int margin = 0;
                ValueAnimator varl = ValueAnimator.ofInt(margin, 50);
                varl.setDuration(1000);
                varl.setRepeatCount(INFINITE);
                varl.setRepeatMode(ValueAnimator.REVERSE);
                varl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) view.getLayoutParams();
                       // lp.setMargins((Integer) animation.getAnimatedValue(), 0, 0, 0);
                        view.setPadding((Integer) animation.getAnimatedValue(), (Integer) animation.getAnimatedValue(),
                                (Integer) animation.getAnimatedValue(), (Integer) animation.getAnimatedValue());
                        view.setLayoutParams(lp);
                    }
                });
                varl.start();
                break;
            case R.id.animatelist:
                AnimationDrawable rocketAnimation = (AnimationDrawable) view.getBackground();
                rocketAnimation.start();
                break;
        }
        animator.playTogether(animatorList);
        animator.start();

    }
}
