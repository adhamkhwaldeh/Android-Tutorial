package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.searcher;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.KissApplication;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.adapter.RecordAdapter;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.Pojo;

import java.util.List;


/**
 * AsyncTask retrieving data from the providers and updating the view
 *
 * @author dorvaryn
 */
public class QuerySearcher extends Searcher {

    private final String query;
    /**
     * Store user preferences
     */
    private SharedPreferences prefs;

    public QuerySearcher(Context activity, QueryInterface queryInterface, RecordAdapter recordAdapter, String query) {
        super(activity, queryInterface, recordAdapter);
        this.query = query;
        prefs = PreferenceManager.getDefaultSharedPreferences(activity);

    }

    @Override
    protected List<Pojo> doInBackground(Void... voids) {
        // Ask for records
        final List<Pojo> pojos = KissApplication.getDataHandler(activity).getResults(
                activity, query);

        // Convert `"number-of-display-elements"` to double first before truncating to int to avoid
        // `java.lang.NumberFormatException` crashes for values larger than `Integer.MAX_VALUE`
        int maxRecords = (Double.valueOf(prefs.getString("number-of-display-elements", String.valueOf(DEFAULT_MAX_RESULTS)))).intValue();

        // Possibly limit number of results post-mortem
        if (pojos.size() > maxRecords) {
            return pojos.subList(0, maxRecords);
        }

        return pojos;
    }

}
