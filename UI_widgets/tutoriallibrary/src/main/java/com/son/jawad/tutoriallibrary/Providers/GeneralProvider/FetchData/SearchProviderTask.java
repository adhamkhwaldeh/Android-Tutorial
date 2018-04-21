package com.son.jawad.tutoriallibrary.Providers.GeneralProvider.FetchData;

import android.content.Context;
import android.os.AsyncTask;

import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.KissApplication;
import com.son.jawad.tutoriallibrary.Providers.GeneralProvider.pojo.Pojo;

import java.util.List;

/**
 * Created by Adhamkh on 2017-09-07.
 */

public class SearchProviderTask extends AsyncTask<Void, Void, List<Pojo>> {

    private Context context;

    private String query;

    private GeneralProviderCallBackListener generalProviderCallBackListener;

    public SearchProviderTask(Context context, String query, GeneralProviderCallBackListener generalProviderCallBackListener) {
        init(context, query);
        this.generalProviderCallBackListener = generalProviderCallBackListener;
    }

    public SearchProviderTask(Context context, String query) {
        init(context, query);
    }

    public void init(Context context, String query) {
        this.context = context;
        this.query = query;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (generalProviderCallBackListener != null)
            generalProviderCallBackListener.PreFetch();
    }

    @Override
    protected List<Pojo> doInBackground(Void... voids) {
        KissApplication.getDataHandler(context).reloadAll();
        return KissApplication.getDataHandler(context).getResults(
                context, query);
    }

    @Override
    protected void onPostExecute(List<Pojo> pojoList) {
        super.onPostExecute(pojoList);
        if (generalProviderCallBackListener != null)
            generalProviderCallBackListener.PostFetch(pojoList);
    }

    public GeneralProviderCallBackListener getGeneralProviderCallBackListener() {
        return generalProviderCallBackListener;
    }

    public void setGeneralProviderCallBackListener(GeneralProviderCallBackListener generalProviderCallBackListener) {
        this.generalProviderCallBackListener = generalProviderCallBackListener;
    }

}
