package com.son.jawad.ui_widgets.Activities.AnimationActivities.BaseActivities;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-10-07.
 */

public class RippleCodeActivity extends AppCompatActivity {

    public Button ripplebtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ripplecode_layout);
        ripplebtn = (Button) findViewById(R.id.ripplebtn);

        int[] attrs = new int[]{R.attr.selectableItemBackground};
        TypedArray typedArray = obtainStyledAttributes(attrs);
        int backgroundResource = typedArray.getResourceId(0, 0);
        typedArray.recycle();
        ripplebtn.setBackgroundResource(backgroundResource);


    }
}
