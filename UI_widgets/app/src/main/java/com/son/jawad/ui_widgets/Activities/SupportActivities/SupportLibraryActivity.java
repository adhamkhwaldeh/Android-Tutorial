package com.son.jawad.ui_widgets.Activities.SupportActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.son.jawad.ui_widgets.Activities.SupportActivities.ConstraintLayoutActivities.ConstraintLayoutActivity;
import com.son.jawad.ui_widgets.Activities.SupportActivities.CoordinateLayoutActivities.CoordinateLayoutActivity;
import com.son.jawad.ui_widgets.Activities.SupportActivities.RecyclerviewActivities.RecyclerViewActivity;
import com.son.jawad.ui_widgets.Activities.SupportActivities.TabLayoutActivities.TabLayoutActivity;
import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-08-28.
 */

public class SupportLibraryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supportlibrary_layout);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.RecyclerViewId:
                startActivity(new Intent(SupportLibraryActivity.this, RecyclerViewActivity.class));
                break;
            case R.id.ViewPagerId:
                startActivity(new Intent(SupportLibraryActivity.this, ViewPagerActivity.class));
                break;
            case R.id.GridLayoutId:
                startActivity(new Intent(SupportLibraryActivity.this, GridLayoutActivity.class));
                break;
            case R.id.PercentLayoutId:
                startActivity(new Intent(SupportLibraryActivity.this, PercentLayoutActivity.class));
                break;
            case R.id.SwipeRefreshLayoutId:
                startActivity(new Intent(SupportLibraryActivity.this, SwipeRefreshLayoutActivity.class));
                break;
            case R.id.tab_layoutId:
                startActivity(new Intent(SupportLibraryActivity.this, TabLayoutActivity.class));
                break;
            case R.id.Buttomtab_layoutId:
                startActivity(new Intent(SupportLibraryActivity.this, BottomBarActivity.class));
                break;
            case R.id.FloatingActionButtonId:
                startActivity(new Intent(SupportLibraryActivity.this, FloatinActionButtonActivity.class));
                break;
            case R.id.CoordinateLayoutId:
                startActivity(new Intent(SupportLibraryActivity.this, CoordinateLayoutActivity.class));
                break;
            case R.id.SlidingPaneLayoutId:
                startActivity(new Intent(SupportLibraryActivity.this, SlidingPaneLayoutActivity.class));
                break;
            case R.id.ConstraintLayoutId:
                startActivity(new Intent(SupportLibraryActivity.this, ConstraintLayoutActivity.class));
                break;
            case R.id.DrawerLayoutId:
                startActivity(new Intent(SupportLibraryActivity.this, DrawerLayoutActivity.class));
                break;

        }
    }
}
