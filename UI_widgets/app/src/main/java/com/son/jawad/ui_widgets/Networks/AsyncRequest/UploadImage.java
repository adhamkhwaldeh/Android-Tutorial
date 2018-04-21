package com.son.jawad.ui_widgets.Networks.AsyncRequest;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.son.jawad.ui_widgets.Networks.RequestCallbackListener;
import com.son.jawad.ui_widgets.Networks.RequestRESTFunctions;
import com.son.jawad.ui_widgets.Networks.UrlResponse;

/**
 * Created by Adhamkh on 2017-09-09.
 */

public class UploadImage<T> extends AsyncTask<Void, Void, UrlResponse<T>> {
    private String Url;
    private int TimeOut = 10000;
    private Class<T> t;
    private Bitmap bitmap;

    private RequestCallbackListener<T> requestCallbackListener;

    public UploadImage(String Url, Bitmap bitmap, Class<T> t, RequestCallbackListener<T> requestCallbackListener) {
        this.t = t;
        this.TimeOut = 10000;
        this.Url = Url;
        this.bitmap = bitmap;
        this.requestCallbackListener = requestCallbackListener;
    }

    public UploadImage(String Url, Object pObject, int TimeOut, Class<T> t, RequestCallbackListener<T> requestCallbackListener) {
        this.t = t;
        this.bitmap = bitmap;
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
        return new RequestRESTFunctions<T>(t).UploadImage(Url, bitmap);

    }

    @Override
    protected void onPostExecute(UrlResponse<T> urlResponse) {
        super.onPostExecute(urlResponse);
        if (requestCallbackListener != null)
            requestCallbackListener.onPostRequest(urlResponse);
    }
}
