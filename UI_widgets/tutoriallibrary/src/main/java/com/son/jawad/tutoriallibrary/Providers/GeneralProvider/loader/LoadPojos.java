package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.loader;

import android.content.Context;
import android.os.AsyncTask;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.dataprovider.Provider;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.Pojo;

import java.util.ArrayList;


public abstract class LoadPojos<T extends Pojo> extends AsyncTask<Void, Void, ArrayList<T>> {

    final Context context;
    String pojoScheme = "(none)://";
    private Provider<T> provider;

    LoadPojos(Context context, String pojoScheme) {
        super();
        this.context = context;
        this.pojoScheme = pojoScheme;
    }

    public void setProvider(Provider<T> provider) {
        this.provider = provider;
    }

    public String getPojoScheme() {
        return pojoScheme;
    }

    @Override
    protected void onPostExecute(ArrayList<T> result) {
        super.onPostExecute(result);
        provider.loadOver(result);
    }

}
