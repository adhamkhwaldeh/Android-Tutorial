package com.son.jawad.ui_widgets.Activities.ProviderActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.son.jawad.tutoriallibrary.Providers.ApplicationsProvider.AppInfo;
import com.son.jawad.tutoriallibrary.Providers.ApplicationsProvider.ApplicationCallBackListener;
import com.son.jawad.tutoriallibrary.Providers.ApplicationsProvider.getApplications;
import com.son.jawad.ui_widgets.Adapters.AppAdapter;
import com.son.jawad.tutoriallibrary.Providers.ApplicationsProvider.AppListLoader;
import com.son.jawad.ui_widgets.R;

import java.util.List;

/**
 * Created by Adhamkh on 2017-09-04.
 */

public class ProviderApplicationActivity extends AppCompatActivity {

    public RecyclerView appList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.providerapplication_layout);
        appList = (RecyclerView) findViewById(R.id.appList);
        appList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        new getApplications(getApplicationContext(), new ApplicationCallBackListener() {
            @Override
            public void onPreexcute() {

            }

            @Override
            public void onPostexcute(List<AppInfo> applist) {
                appList.setAdapter(new AppAdapter(applist, getApplicationContext()));
            }
        });//.execute();

        AppListLoader appListLoader = new AppListLoader(getApplicationContext());
        appListLoader.registerListener(0, new Loader.OnLoadCompleteListener<List<AppInfo>>() {
            @Override
            public void onLoadComplete(Loader<List<AppInfo>> loader, List<AppInfo> data) {
                appList.setAdapter(new AppAdapter(data, getApplicationContext()));
            }
        });
        appListLoader.startLoading();

    }


}
