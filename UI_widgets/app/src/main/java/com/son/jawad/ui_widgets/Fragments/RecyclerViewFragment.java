package com.son.jawad.ui_widgets.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.son.jawad.ui_widgets.Adapters.RecyclerViewAdapter;
import com.son.jawad.ui_widgets.Enums.RecyclerViewPageType;
import com.son.jawad.ui_widgets.Models.ModelsHelper;
import com.son.jawad.ui_widgets.R;


/**
 * Created by Adhamkh on 2017-08-30.
 */

public class RecyclerViewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.recyclerviewfragment_layout, container, false);
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new RecyclerViewAdapter(getContext(), ModelsHelper.getrecyclerViewModelList(), RecyclerViewPageType.List_Type));
    }


}
