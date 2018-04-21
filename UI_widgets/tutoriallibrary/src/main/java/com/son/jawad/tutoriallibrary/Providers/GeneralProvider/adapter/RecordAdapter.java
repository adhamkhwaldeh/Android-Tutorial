package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.KissApplication;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.result.AppResult;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.result.ContactsResult;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.result.PhoneResult;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.result.Result;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.result.SearchResult;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.result.SettingsResult;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.result.ShortcutsResult;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.result.TogglesResult;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.searcher.QueryInterface;

import java.util.ArrayList;


public class RecordAdapter extends ArrayAdapter<Result> {

    private final QueryInterface parent;
    /**
     * Array list containing all the results currently displayed
     */
    private ArrayList<Result> results = new ArrayList<>();

    public RecordAdapter(Context context, QueryInterface parent, int textViewResourceId,
                         ArrayList<Result> results) {
        super(context, textViewResourceId, results);

        this.parent = parent;
        this.results = results;
    }

    public int getViewTypeCount() {
        return 7;
    }

    public int getItemViewType(int position) {
        if (results.get(position) instanceof AppResult)
            return 0;
        else if (results.get(position) instanceof SearchResult)
            return 1;
        else if (results.get(position) instanceof ContactsResult)
            return 2;
        else if (results.get(position) instanceof TogglesResult)
            return 3;
        else if (results.get(position) instanceof SettingsResult)
            return 4;
        else if (results.get(position) instanceof PhoneResult)
            return 5;
        else if (results.get(position) instanceof ShortcutsResult)
            return 6;
        else
            return -1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return results.get(position).display(getContext(), results.size() - position, convertView);
    }

    public void onLongClick(final int pos, View v) {
        PopupMenu menu = results.get(pos).getPopupMenu(getContext(), this, v);

        //check if menu contains elements and if yes show it
        if (menu.getMenu().size() > 0) {
            menu.show();
        }
    }

    public void onClick(final int position, View v) {
        final Result result;

        try {
            result = results.get(position);
            result.launch(getContext(), v);
        } catch (ArrayIndexOutOfBoundsException ignored) {
            return;
        }

        // Record the launch after some period,
        // * to ensure the animation runs smoothly
        // * to avoid a flickering -- launchOccurred will refresh the list
        // Thus TOUCH_DELAY * 3
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                parent.launchOccurred(results.size() - position, result);
            }
        }, KissApplication.TOUCH_DELAY * 3);

    }

    public void removeResult(Result result) {
        results.remove(result);
        result.deleteRecord(getContext());
        notifyDataSetChanged();
    }
}
