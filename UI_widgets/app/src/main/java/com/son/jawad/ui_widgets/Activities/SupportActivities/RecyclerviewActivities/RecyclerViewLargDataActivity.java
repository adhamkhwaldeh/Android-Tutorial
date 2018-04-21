package com.son.jawad.ui_widgets.Activities.SupportActivities.RecyclerviewActivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.son.jawad.ui_widgets.Adapters.ActorAdapter;
import com.son.jawad.ui_widgets.Models.ModelsHelper;
import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-09-01.
 */

public class RecyclerViewLargDataActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ActorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerviewlargdata_layout);

        adapter = new ActorAdapter(ModelsHelper.getActorListSortedByRating());
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sort_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_by_name:
                adapter.swapItems(ModelsHelper.getActorListSortedByName());
                return true;
            case R.id.sort_by_rating:
                adapter.swapItems(ModelsHelper.getActorListSortedByRating());
                return true;
            case R.id.sort_by_birth:
                adapter.swapItems(ModelsHelper.getActorListSortedByYearOfBirth());
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
