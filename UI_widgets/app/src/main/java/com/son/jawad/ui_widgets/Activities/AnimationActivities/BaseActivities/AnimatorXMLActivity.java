package com.son.jawad.ui_widgets.Activities.AnimationActivities.BaseActivities;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-10-06.
 */

public class AnimatorXMLActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animatorxml_layout);
    }

    public void onClick(View view) {
        int Id = R.animator.combo;
        switch (view.getId()) {
            case R.id.combobtn:
                Id = R.animator.combo;
                break;
            case R.id.fadebtn:
                Id = R.animator.fade;
                break;
            case R.id.movebtn:
                Id = R.animator.move;
                break;
            case R.id.scalebtn:
                Id = R.animator.scale;
                break;
            case R.id.spinbtn:
                Id = R.animator.spin;
                break;
        }
        Animator animator = AnimatorInflater.loadAnimator(getApplicationContext(), Id);
        animator.setTarget(view);
        animator.start();
    }
}
