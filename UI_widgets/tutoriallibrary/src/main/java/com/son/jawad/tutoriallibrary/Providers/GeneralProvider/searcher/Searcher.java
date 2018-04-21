package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.searcher;


import android.content.Context;
import android.os.AsyncTask;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.adapter.RecordAdapter;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.Pojo;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.result.Result;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public abstract class Searcher extends AsyncTask<Void, Void, List<Pojo>> {
    protected static final int DEFAULT_MAX_RESULTS = 25;

    final Context activity;
    RecordAdapter recordAdapter;
    QueryInterface queryInterface;

    Searcher(Context activity, QueryInterface queryInterface, RecordAdapter recordAdapter) {
        super();
        this.recordAdapter = recordAdapter;
        this.activity = activity;
    }

    @Override
    protected void onPostExecute(List<Pojo> pojos) {
        super.onPostExecute(pojos);
        recordAdapter.clear();

        Collection<Result> results = new ArrayList<>();

        if (pojos != null) {
            for (int i = pojos.size() - 1; i >= 0; i--) {
                results.add(Result.fromPojo(queryInterface, pojos.get(i)));
            }

            recordAdapter.addAll(results);
        }
        //activity.resetTask();
    }

}
