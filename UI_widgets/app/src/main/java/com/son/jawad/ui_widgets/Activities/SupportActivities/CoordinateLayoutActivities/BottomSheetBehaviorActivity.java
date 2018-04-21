package com.son.jawad.ui_widgets.Activities.SupportActivities.CoordinateLayoutActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.son.jawad.ui_widgets.Adapters.RecyclerViewAdapter;
import com.son.jawad.ui_widgets.Enums.RecyclerViewPageType;
import com.son.jawad.ui_widgets.Listeners.RecyclerViewItemClickListener;
import com.son.jawad.ui_widgets.Models.ModelsHelper;
import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-08-30.
 */

public class BottomSheetBehaviorActivity extends AppCompatActivity {

    public NestedScrollView design_bottom_sheet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttombehavior_layout);

        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_content);
        design_bottom_sheet = (NestedScrollView) findViewById(R.id.design_bottom_sheet);

        final BottomSheetBehavior behavior = BottomSheetBehavior.from(design_bottom_sheet);

        coordinatorLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerViewAdapter itemAdapter = new RecyclerViewAdapter(BottomSheetBehaviorActivity.this,
                ModelsHelper.getrecyclerViewModelList(), RecyclerViewPageType.List_Type,
                new RecyclerViewItemClickListener() {
            @Override
            public void onItemClick() {
                if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });
        recyclerView.setAdapter(itemAdapter);


    }
}
