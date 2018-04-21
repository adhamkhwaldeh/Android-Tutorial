package com.son.jawad.ui_widgets.Activities.AnimationActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.ui_widgets.Activities.AnimationActivities.BaseActivities.AnimationCodeActivity;
import com.son.jawad.ui_widgets.Activities.AnimationActivities.BaseActivities.AnimationXMLActivity;
import com.son.jawad.ui_widgets.Activities.AnimationActivities.BaseActivities.AnimatorCodeActivity;
import com.son.jawad.ui_widgets.Activities.AnimationActivities.BaseActivities.AnimatorXMLActivity;
import com.son.jawad.ui_widgets.Activities.AnimationActivities.BaseActivities.DrawableActivity;
import com.son.jawad.ui_widgets.Activities.AnimationActivities.BaseActivities.PreAnimatorActivity;
import com.son.jawad.ui_widgets.Activities.AnimationActivities.BaseActivities.RippleCodeActivity;
import com.son.jawad.ui_widgets.Activities.AnimationActivities.BaseActivities.RippleXMLActivity;
import com.son.jawad.ui_widgets.Activities.AnimationActivities.CustomRipple.CustomRippleActivity;
import com.son.jawad.ui_widgets.Activities.AnimationActivities.CustomRipple.ReppleEffectActivity;
import com.son.jawad.ui_widgets.Activities.AnimationActivities.VectorActivities.VectorActivity;
import com.son.jawad.ui_widgets.Activities.AnimationActivities.revealActivities.RevealActivity;
import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-10-06.
 */

public class AnimationMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animationmain_layout);
    }

    public void onclickbtn(View view) {

        switch (view.getId()) {
            case R.id.animationxmlbtn:
                startActivity(new Intent(AnimationMainActivity.this, AnimationXMLActivity.class));
                break;
            case R.id.animationcodebtn:
                startActivity(new Intent(AnimationMainActivity.this, AnimationCodeActivity.class));
                break;
            case R.id.preanimatorbtn:
              //  startActivity(new Intent(AnimationMainActivity.this, PreAnimatorActivity.class));
                break;
            case R.id.animatorxmlbtn:
                startActivity(new Intent(AnimationMainActivity.this, AnimatorXMLActivity.class));
                break;
            case R.id.animatorcodebtn:
                startActivity(new Intent(AnimationMainActivity.this, AnimatorCodeActivity.class));
                break;
            case R.id.ripplexmlbtn:
                startActivity(new Intent(AnimationMainActivity.this, RippleXMLActivity.class));
                break;
            case R.id.ripplecodebtn:
                startActivity(new Intent(AnimationMainActivity.this, RippleCodeActivity.class));
                break;
            case R.id.customripplebtn:
                startActivity(new Intent(AnimationMainActivity.this, CustomRippleActivity.class));
                break;
            case R.id.rippleeffectbtn:
                startActivity(new Intent(AnimationMainActivity.this, ReppleEffectActivity.class));
                break;
            case R.id.revealeffectbtn:
                startActivity(new Intent(AnimationMainActivity.this, RevealActivity.class));
                break;
            case R.id.vectortbtn:
                startActivity(new Intent(AnimationMainActivity.this, VectorActivity.class));
                break;
            case R.id.drawablecodebtn:
                startActivity(new Intent(AnimationMainActivity.this, DrawableActivity.class));
                break;
        }

    }

}
