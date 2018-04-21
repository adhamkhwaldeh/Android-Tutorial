package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.searcher;

import android.content.Context;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.adapter.RecordAdapter;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.Pojo;

import java.util.ArrayList;
import java.util.List;


/**
 * Retrieve pojos from history
 */
public class NullSearcher extends Searcher {

    public NullSearcher(Context activity, QueryInterface queryInterface, RecordAdapter recordAdapter, String query) {
        super(activity, queryInterface, recordAdapter);
    }
    @Override
    protected List<Pojo> doInBackground(Void... voids) {
        return new ArrayList<>();
    }
}
