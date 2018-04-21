package com.son.jawad.ui_widgets.Activities.SupportActivities.RecyclerviewActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.son.jawad.tutoriallibrary.RecyclerViewCustomLayoutManager.FixedGridLayoutManager;
import com.son.jawad.ui_widgets.Adapters.RecyclerViewAdapter;
import com.son.jawad.ui_widgets.Enums.RecyclerViewPageType;
import com.son.jawad.ui_widgets.Models.ModelsHelper;
import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-09-01.
 */

public class RecyclerViewFixedLayoutActivity extends AppCompatActivity {
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerviewfixedlayout_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new FixedGridLayoutManager());
        recyclerView.setAdapter(new RecyclerViewAdapter(getApplicationContext(),
                ModelsHelper.getrecyclerViewModelList(), RecyclerViewPageType.List_Type));
    }

}
