package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.searcher;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.KissApplication;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.adapter.RecordAdapter;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.Pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Retrieve pojos from history
 */
public class HistorySearcher extends Searcher {
    private SharedPreferences prefs;

    public HistorySearcher(Context activity, QueryInterface queryInterface, RecordAdapter recordAdapter, String query) {
        super(activity, queryInterface, recordAdapter);
        prefs = PreferenceManager.getDefaultSharedPreferences(activity);
    }

    @Override
    protected List<Pojo> doInBackground(Void... voids) {
        // Ask for records
        boolean smartHistory = !prefs.getString("history-mode", "recency").equals("recency");
        boolean excludeFavorites = prefs.getBoolean("exclude-favorites", false);

        // Convert `"number-of-display-elements"` to double first before truncating to int to avoid
        // `java.lang.NumberFormatException` crashes for values larger than `Integer.MAX_VALUE`
        int maxRecords = (Double.valueOf(prefs.getString("number-of-display-elements", String.valueOf(DEFAULT_MAX_RESULTS)))).intValue();

        //Gather favorites
//        ArrayList<Pojo> favoritesPojo = new ArrayList<Pojo>(0);
//        if (excludeFavorites) {
//            favoritesPojo = KissApplication.getDataHandler(activity).getFavorites(activity.tryToRetrieve);
//        }

        return new Vector<>();// KissApplication.getDataHandler(activity).getHistory(activity, maxRecords, smartHistory, favoritesPojo);
    }
}
