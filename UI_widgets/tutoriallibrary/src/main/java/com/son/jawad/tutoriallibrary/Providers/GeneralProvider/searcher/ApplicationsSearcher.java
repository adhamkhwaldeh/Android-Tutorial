package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.searcher;

import android.app.Activity;
import android.content.Context;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.KissApplication;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.adapter.RecordAdapter;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.Pojo;

import java.util.List;


/**
 * Returns the list of all applications on the system
 */
public class ApplicationsSearcher extends Searcher {

    public ApplicationsSearcher(Context activity, QueryInterface queryInterface, RecordAdapter recordAdapter, String query) {
        super(activity, queryInterface, recordAdapter);
    }

    @Override
    protected List<Pojo> doInBackground(Void... voids) {
        // Ask for records
        return KissApplication.getDataHandler(activity).getApplications();
    }
}
