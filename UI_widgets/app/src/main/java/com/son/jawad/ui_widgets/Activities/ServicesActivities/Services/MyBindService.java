package com.son.jawad.ui_widgets.Activities.ServicesActivities.Services;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;

import com.son.jawad.ui_widgets.Models.BadgeResponseModel;
import com.son.jawad.ui_widgets.Models.Response;
import com.son.jawad.ui_widgets.Networks.AsyncRequest.GetRequest;
import com.son.jawad.ui_widgets.Networks.RequestCallbackListener;
import com.son.jawad.ui_widgets.Networks.RequestRESTFunctions;
import com.son.jawad.ui_widgets.Networks.ResponseState;
import com.son.jawad.ui_widgets.Networks.UrlResponse;

/**
 * Created by Adhamkh on 2017-09-12.
 */

public class MyBindService extends Service {

    public IBinder iBinder = new MyBindServiceBinder();

    public OnBindCallBackListener onBindCallBackListener;

    public OnBindCallBackListener getOnBindCallBackListener() {
        return onBindCallBackListener;
    }

    public void setOnBindCallBackListener(OnBindCallBackListener onBindCallBackListener) {
        this.onBindCallBackListener = onBindCallBackListener;
    }

    public void AsyncBadge() {


        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        final UrlResponse<BadgeResponseModel> urlResponse =
                                new RequestRESTFunctions<>(BadgeResponseModel.class).
                                        GetRequest("http://10.117.0.150/RoyalApplication/api/countupdatestate", 10000, null);

                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (onBindCallBackListener != null)
                                    if (urlResponse.getResponseObject() != null)
                                        if (urlResponse.getResponseObject().getOk())
                                            onBindCallBackListener.onbackBadge(urlResponse.getResponseObject().getCount());

                            }
                        });
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();


//        new AsyncTask<Void, Void, Void>() {
//            UrlResponse<BadgeResponseModel> urlResponse;
//
//            @Override
//            protected Void doInBackground(Void... params) {
//                try {
//                    while (true) {
//
//                        Thread.sleep(10000);
//
//
//                        new Handler().post(new Runnable() {
//                            @Override
//                            public void run() {
//                                if (onBindCallBackListener != null)
//                                    if (urlResponse.getResponseObject() != null)
//                                        if (urlResponse.getResponseObject().getOk())
//                                            onBindCallBackListener.onbackBadge(urlResponse.getResponseObject().getCount());
//
//                            }
//                        });
//
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                return null;
//            }
//
//        }.execute();

    }

    public class MyBindServiceBinder extends Binder {
        public MyBindService getService() {
            // Return this instance of LocalService so clients can call public methods
            return MyBindService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

}
