package com.son.jawad.ui_widgets.Networks.AsyncRequest;

import android.os.AsyncTask;

import com.son.jawad.ui_widgets.Networks.RequestCallbackListener;
import com.son.jawad.ui_widgets.Networks.RequestRESTFunctions;
import com.son.jawad.ui_widgets.Networks.UrlResponse;

/**
 * Created by Adhamkh on 2017-09-08.
 */

public class PostRequest<T> extends AsyncTask<Void, Void, UrlResponse<T>> {
    private String Url;
    private int TimeOut = 10000;
    private Class<T> t;
    private Object pObject;

    private RequestCallbackListener<T> requestCallbackListener;

    public PostRequest(String Url, Class<?> pObject, Class<T> t, RequestCallbackListener<T> requestCallbackListener) {
        this.t = t;
        this.TimeOut = 10000;
        this.Url = Url;
        this.pObject = pObject;
        this.requestCallbackListener = requestCallbackListener;
    }

    public PostRequest(String Url, Object pObject, int TimeOut, Class<T> t, RequestCallbackListener<T> requestCallbackListener) {
        this.t = t;
        this.pObject = pObject;
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
        return new RequestRESTFunctions<T>(t).PostRequest(Url, pObject, null, TimeOut);

    }

    @Override
    protected void onPostExecute(UrlResponse<T> urlResponse) {
        super.onPostExecute(urlResponse);
        if (requestCallbackListener != null)
            requestCallbackListener.onPostRequest(urlResponse);
    }
}
