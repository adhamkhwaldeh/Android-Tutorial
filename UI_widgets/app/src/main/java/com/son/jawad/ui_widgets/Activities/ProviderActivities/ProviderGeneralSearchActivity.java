package com.son.jawad.ui_widgets.Activities.ProviderActivities;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.DataHandler;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.FetchData.GeneralProviderCallBackListener;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.FetchData.SearchProviderTask;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.KissApplication;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.adapter.RecordAdapter;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.dataprovider.Provider;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.Pojo;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.result.Result;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.searcher.QueryInterface;
import com.son.jawad.ui_widgets.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.son.jawad.tutoriallibrary.Providers.GeneralProvider.LoadingTag.FULL_LOAD_OVER;
import static com.son.jawad.tutoriallibrary.Providers.GeneralProvider.LoadingTag.LOAD_OVER;
import static com.son.jawad.tutoriallibrary.Providers.GeneralProvider.LoadingTag.START_LOAD;

/**
 * Created by Adhamkh on 2017-09-07.
 */

public class ProviderGeneralSearchActivity extends AppCompatActivity implements QueryInterface {

    private BroadcastReceiver mReceiver;

    public Context context;
    public RecordAdapter adapter;
    public ListView list;
    public EditText edit_query;
    final static private List<String> PROVIDER_NAMES = Arrays.asList(
            "app", "contacts", "phone", "search", "settings", "shortcuts", "toggles"
    );

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.providergeneralsearch_layout);
        list = (ListView) findViewById(R.id.list);
        edit_query = (EditText) findViewById(R.id.edit_query);

        context = this;
        IntentFilter intentFilter = new IntentFilter(START_LOAD);
        IntentFilter intentFilterBis = new IntentFilter(LOAD_OVER);
        IntentFilter intentFilterTer = new IntentFilter(FULL_LOAD_OVER);
        this.adapter = new RecordAdapter(this, this, R.layout.item_app, new ArrayList<Result>());

        this.list.setLongClickable(true);
        this.list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int pos, long id) {
                ((RecordAdapter) parent.getAdapter()).onLongClick(pos, v);
                return true;
            }
        });
        this.adapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();

//                if (adapter.isEmpty()) {
//                    listContainer.setVisibility(View.GONE);
//                    listEmpty.setVisibility(View.VISIBLE);
//                } else {
//                    listContainer.setVisibility(View.VISIBLE);
//                    listEmpty.setVisibility(View.GONE);
//                }

            }
        });
        registerLongClickOnFavorites();

        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equalsIgnoreCase(LOAD_OVER)) {
                    Log.v("", "");
                    edit_query.setEnabled(true);
                    //updateRecords(searchEditText.getText().toString());
                } else if (intent.getAction().equalsIgnoreCase(FULL_LOAD_OVER)) {
                    // Run GC once to free all the garbage accumulated during provider initialization
                    System.gc();

                    //displayQuickFavoritesBar(true, false);
                    // displayLoader(false);

                } else if (intent.getAction().equalsIgnoreCase(START_LOAD)) {
                    //    displayLoader(true);
                    Log.v("", "");
                }
            }
        };


        this.registerReceiver(mReceiver, intentFilter);
        this.registerReceiver(mReceiver, intentFilterBis);
        this.registerReceiver(mReceiver, intentFilterTer);
        DataHandler dataHandler = new DataHandler(context);
        Log.v("", "");

        edit_query.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() > 2)
                    search(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    public void launchOccurred(int index, Result result) {

    }


    public void search(String s) {
        new SearchProviderTask(getApplication(), s, new GeneralProviderCallBackListener() {
            @Override
            public void PreFetch() {
                Log.v("", "");
            }

            @Override
            public void PostFetch(List<Pojo> pojoList) {
                Collection<Result> results = new ArrayList<>();
                adapter.clear();
                if (pojoList != null) {
                    for (int i = pojoList.size() - 1; i >= 0; i--) {
                        results.add(Result.fromPojo(ProviderGeneralSearchActivity.this, pojoList.get(i)));
                    }
                    adapter.addAll(results);
                }
                list.setAdapter(adapter);
                Log.v("", "");
            }
        }).execute();

    }


    private void registerLongClickOnFavorites() {
        View.OnLongClickListener listener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                int favNumber = Integer.parseInt((String) view.getTag());
                ArrayList<Pojo> favorites = KissApplication.getDataHandler(ProviderGeneralSearchActivity.this).getFavorites(1000);
//                if (favNumber >= favorites.size()) {
//                    // Clicking on a favorite before everything is loaded.
//                    Log.i(TAG, "Long clicking on an unitialized favorite.");
//                    return false;
//                }
                // Favorites handling
                Pojo pojo = favorites.get(favNumber);
                final Result result = Result.fromPojo(ProviderGeneralSearchActivity.this, pojo);
                result.getPopupMenu(ProviderGeneralSearchActivity.this, adapter, view).show();
                return true;
            }
        };
//        for (int id : favBarIds) {
//            findViewById(id).setOnLongClickListener(listener);
//        }
//        for (int id : favsIds) {
//            findViewById(id).setOnLongClickListener(listener);
//        }
    }
}
