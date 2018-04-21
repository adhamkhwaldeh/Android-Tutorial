package com.son.jawad.ui_widgets.Activities.UIActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.son.jawad.ui_widgets.Adapters.AutocompleteTextAdapter;
import com.son.jawad.ui_widgets.Models.AutoCompleteModel;
import com.son.jawad.ui_widgets.R;

import java.util.List;
import java.util.Vector;

/**
 * Created by Adhamkh on 2017-08-17.
 */

public class AutoCompleteActivity extends AppCompatActivity {

    public AutoCompleteTextView autoCompleteTextView, autocompletecustom;
    public String[] lst = {"C", "C++", "Java", ".NET", "iPhone", "Android", "ASP.NET", "PHP"};
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocomplete_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autocompletetext);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(AutoCompleteActivity.this, R.layout.autocomplete_item, lst));


        List<AutoCompleteModel> namesmodel = new Vector<>();
        namesmodel.add(new AutoCompleteModel("name1"));
        namesmodel.add(new AutoCompleteModel("name2"));
        namesmodel.add(new AutoCompleteModel("name3"));
        namesmodel.add(new AutoCompleteModel("name4"));
        namesmodel.add(new AutoCompleteModel("name5"));
        namesmodel.add(new AutoCompleteModel("name6"));
        namesmodel.add(new AutoCompleteModel("name7"));
        namesmodel.add(new AutoCompleteModel("name8"));
        namesmodel.add(new AutoCompleteModel("name9"));
        namesmodel.add(new AutoCompleteModel("name10"));

        autocompletecustom = (AutoCompleteTextView) findViewById(R.id.autocompletecustom);
        autocompletecustom.setAdapter(new AutocompleteTextAdapter(AutoCompleteActivity.this, namesmodel));
        autocompletecustom.setThreshold(3);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu, menu);

         MenuItem item = menu.findItem(R.id.action_search);

        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        //searchView.setOnQueryTextListener(AutoCompleteActivity.this);
        searchView.setQueryHint(getResources().getString(R.string.searchbyname));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        //searchView.setSuggestionsAdapter(new );
        /*MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        // Do something when collapsed
                        //  adapter.setFilter(mCountryModel);
                        return true; // Return true to collapse action view
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        // Do something when expanded
                        return true; // Return true to expand action view
                    }
                });*/

        return super.onCreateOptionsMenu(menu);
    }

    /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu, menu);
        //  inflater.inflate(R.menu.menu_main, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        //searchView.setOnQueryTextListener(AutoCompleteActivity.this);
        searchView.setQueryHint(getResources().getString(R.string.searchbyname));
        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        // Do something when collapsed
                        //  adapter.setFilter(mCountryModel);
                        return true; // Return true to collapse action view
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        // Do something when expanded
                        return true; // Return true to expand action view
                    }
                });
        return true;//super.onCreateOptionsMenu(menu);
    }*/

}
