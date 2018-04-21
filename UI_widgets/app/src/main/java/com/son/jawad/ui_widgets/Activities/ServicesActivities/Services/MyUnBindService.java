package com.son.jawad.ui_widgets.Activities.ServicesActivities.Services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Pair;

import com.google.gson.Gson;
import com.son.jawad.ui_widgets.Models.Response;
import com.son.jawad.ui_widgets.Networks.AsyncRequest.GetRequest;
import com.son.jawad.ui_widgets.Networks.ResponseMessage;
import com.son.jawad.ui_widgets.Networks.ResponseState;
import com.son.jawad.ui_widgets.Networks.UrlResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by Adhamkh on 2017-09-12.
 */

public class MyUnBindService extends Service {

    public static int NOTIF_ID = 0;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext());
        builder.setPriority(Notification.PRIORITY_MIN);
        startForeground(NOTIF_ID, builder.getNotification());
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.cancel(NOTIF_ID);
        updating();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void updating() {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        GetRequest("http://10.117.0.150/RoyalApplication/api/updatestate",
                                10000, null);
//                        new GetRequest<>("http://192.168.1.3/RoyalApplication/api/updatestate",
//                                10000, Response.class, null).execute();
                        Thread.sleep(10000);
                    } catch (Exception ex) {
                    }
                }
            }
        });
        thread.start();
    }

    public UrlResponse<Response> GetRequest(String url, int timeout, List<Pair<String, String>> Properties) {
        HttpURLConnection c = null;
        UrlResponse<Response> urlResponse;
        try {
            URL u = new URL(url);
            c = (HttpURLConnection) u.openConnection();
            c.setInstanceFollowRedirects(false);
            c.setRequestMethod("GET");
            c.setRequestProperty("charset", "utf-8");
            c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (Properties != null) {
                for (Pair<String, String> pair : Properties) {
                    c.setRequestProperty(pair.first, pair.second);
                }
            }
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(timeout);
            c.setReadTimeout(timeout);
            c.connect();

            int status = c.getResponseCode();
            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream(), "UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                    try {
                        String s = sb.toString();
                        return new UrlResponse<Response>(parseResult(s), new ResponseMessage(ResponseState.RESPONSE_SUCCESS));
                    } catch (Exception e) {
                        urlResponse = new UrlResponse<Response>(null, new ResponseMessage(ResponseState.RESPONSE_PARSEERROR));
                    }
                case 500:
                case 400:
                    urlResponse = new UrlResponse<Response>(null, new ResponseMessage(ResponseState.RESPONSE_SERVERERROR));
                default:
                    urlResponse = new UrlResponse<Response>(null, new ResponseMessage(ResponseState.RESPONSE_SERVERERROR));
            }
        } catch (MalformedURLException ex) {
            urlResponse = new UrlResponse<Response>(null, new ResponseMessage(ResponseState.RESPONSE_ERRORCONNECTION));
        } catch (IOException ex) {
            urlResponse = new UrlResponse<Response>(null, new ResponseMessage(ResponseState.RESPONSE_ERRORCONNECTION));
        } catch (Exception ex) {
            urlResponse = new UrlResponse<Response>(null, new ResponseMessage(ResponseState.RESPONSE_ERRORCONNECTION));
        } finally {
            if (c != null) {
                try {
                    c.disconnect();

                } catch (Exception ex) {
                    urlResponse = new UrlResponse<Response>(null, new ResponseMessage(ResponseState.RESPONSE_ERRORCONNECTION));
                }
            }
        }
        return urlResponse;
    }

    public Response parseResult(String gsonstring) {
        Gson gson = new Gson();
        return gson.fromJson(gsonstring, Response.class);
    }


}
