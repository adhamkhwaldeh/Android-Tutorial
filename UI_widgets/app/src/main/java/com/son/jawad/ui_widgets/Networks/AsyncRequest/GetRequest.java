package com.son.jawad.ui_widgets.Networks.AsyncRequest;

import android.os.AsyncTask;

import com.son.jawad.ui_widgets.Networks.RequestCallbackListener;
import com.son.jawad.ui_widgets.Networks.RequestRESTFunctions;
import com.son.jawad.ui_widgets.Networks.UrlResponse;

public class GetRequest<T> extends AsyncTask<Void, Void, UrlResponse<T>> {
    private String Url;
    private int TimeOut = 10000;
    private Class<T> t;
    private RequestCallbackListener<T> requestCallbackListener;

    public GetRequest(String Url, RequestCallbackListener<T> requestCallbackListener) {
        this.TimeOut = 10000;
        this.Url = Url;
        this.requestCallbackListener = requestCallbackListener;
    }

    public GetRequest(String Url, int TimeOut, Class<T> t, RequestCallbackListener<T> requestCallbackListener) {
        this.t = t;
        this.TimeOut = TimeOut;
        this.Url = Url;
        this.requestCallbackListener = requestCallbackListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (requestCallbackListener != null)
            requestCallbackListener.onPreRequest();
    }

    @Override
    protected UrlResponse<T> doInBackground(Void... voids) {
        return new RequestRESTFunctions<T>(t).GetRequest(Url, TimeOut, null);

    }

    @Override
    protected void onPostExecute(UrlResponse<T> urlResponse) {
        super.onPostExecute(urlResponse);
        if (requestCallbackListener != null)
            requestCallbackListener.onPostRequest(urlResponse);
    }
}
