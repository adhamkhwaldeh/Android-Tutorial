package com.son.jawad.ui_widgets.Activities.SupportActivities.RecyclerviewActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.ui_widgets.Activities.SupportActivities.RecyclerviewActivities.RecyclerViewAnimationActivity.RecyclerviewanimationActivity;
import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-08-31.
 */

public class RecyclerViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_layout);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.RecyclerViewlayouttypebtn:
                startActivity(new Intent(RecyclerViewActivity.this, RecyclerViewLayoutManagerActivity.class));
                break;
            case R.id.RecyclerViewCustomlayoutManagerbtn:
                startActivity(new Intent(RecyclerViewActivity.this, RecyclerViewFixedLayoutActivity.class));
                break;
            case R.id.RecyclerViewItemAnimatorbtn:
                startActivity(new Intent(RecyclerViewActivity.this, RecyclerviewanimationActivity.class));
                break;
            case R.id.RecyclerViewPaggingbtn:
                startActivity(new Intent(RecyclerViewActivity.this, RecyclerViewPaggingActivity.class));
                break;
            case R.id.RecyclerViewLargDatabtn:
                startActivity(new Intent(RecyclerViewActivity.this, RecyclerViewLargDataActivity.class));
                break;
        }
    }

}
