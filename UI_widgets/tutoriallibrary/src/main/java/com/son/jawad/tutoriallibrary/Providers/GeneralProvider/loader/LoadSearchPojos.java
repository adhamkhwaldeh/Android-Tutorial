package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.loader;

import android.content.Context;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.SearchPojo;

import java.util.ArrayList;


public class LoadSearchPojos extends LoadPojos<SearchPojo> {

    public LoadSearchPojos(Context context) {
        super(context, "none://");
    }

    @Override
    protected ArrayList<SearchPojo> doInBackground(Void... params) {
        return null;
    }
}
