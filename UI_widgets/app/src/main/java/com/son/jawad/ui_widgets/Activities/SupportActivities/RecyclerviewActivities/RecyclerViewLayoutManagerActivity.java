package com.son.jawad.ui_widgets.Activities.SupportActivities.RecyclerviewActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.son.jawad.tutoriallibrary.RecyclerViewDecoration.InsetDecoration;
import com.son.jawad.ui_widgets.Adapters.RecyclerViewAdapter;
import com.son.jawad.ui_widgets.Enums.RecyclerViewPageType;
import com.son.jawad.ui_widgets.Models.ModelsHelper;
import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-08-28.
 */
public class RecyclerViewLayoutManagerActivity extends AppCompatActivity {

    public RecyclerView SliderRecyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerviewlayoutmanager_layout);
        SliderRecyclerview = (RecyclerView) findViewById(R.id.SliderRecyclerview);
        SliderRecyclerview.setLayoutManager(new LinearLayoutManager(RecyclerViewLayoutManagerActivity.this));
        SliderRecyclerview.setAdapter(new RecyclerViewAdapter(RecyclerViewLayoutManagerActivity.this, ModelsHelper.getrecyclerViewModelList(),
                RecyclerViewPageType.List_Type));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Listingbtn:
//                RecyclerView.ItemDecoration itemDecoration=new InsetDecoration(getApplicationContext());
//                SliderRecyclerview.addItemDecoration(itemDecoration);
                SliderRecyclerview.setLayoutManager(new LinearLayoutManager(RecyclerViewLayoutManagerActivity.this));
                RecyclerViewAdapter recyclerViewAdapter = ((RecyclerViewAdapter) SliderRecyclerview.getAdapter());
                SliderRecyclerview.setAdapter(new RecyclerViewAdapter(RecyclerViewLayoutManagerActivity.this, recyclerViewAdapter.recyclerViewModelList,
                        RecyclerViewPageType.List_Type));
                //recyclerViewAdapter.updatelayout(RecyclerViewPageType.List_Type);
                break;
            case R.id.Gridbtn:
                SliderRecyclerview.setLayoutManager(new GridLayoutManager(RecyclerViewLayoutManagerActivity.this, 2));
                RecyclerViewAdapter recyclerViewAdapter1 = ((RecyclerViewAdapter) SliderRecyclerview.getAdapter());
                SliderRecyclerview.setAdapter(new RecyclerViewAdapter(RecyclerViewLayoutManagerActivity.this, recyclerViewAdapter1.recyclerViewModelList,
                        RecyclerViewPageType.Grid_Type));
                // recyclerViewAdapter1.updatelayout(RecyclerViewPageType.Grid_Type);
                break;
            case R.id.pagerbtn:
                 SnapHelper snapHelper = new LinearSnapHelper();
                snapHelper.attachToRecyclerView(SliderRecyclerview);
                SliderRecyclerview.setLayoutManager(new LinearLayoutManager(RecyclerViewLayoutManagerActivity.this, LinearLayoutManager.HORIZONTAL, false));
                RecyclerViewAdapter recyclerViewAdapter2 = ((RecyclerViewAdapter) SliderRecyclerview.getAdapter());
                SliderRecyclerview.setAdapter(new RecyclerViewAdapter(RecyclerViewLayoutManagerActivity.this, recyclerViewAdapter2.recyclerViewModelList,
                        RecyclerViewPageType.Pager_Type));
                //recyclerViewAdapter2.updatelayout(RecyclerViewPageType.Pager_Type);
                break;
            case R.id.staggeredbtn:
                //SliderRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(3, 1));
                SliderRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                RecyclerViewAdapter recyclerViewAdapter3 = ((RecyclerViewAdapter) SliderRecyclerview.getAdapter());
                SliderRecyclerview.setAdapter(new RecyclerViewAdapter(RecyclerViewLayoutManagerActivity.this, recyclerViewAdapter3.recyclerViewModelList,
                        RecyclerViewPageType.Staggered_Type));
                break;
        }
    }

}