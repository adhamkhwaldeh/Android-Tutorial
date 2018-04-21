package com.son.jawad.ui_widgets.Networks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Pair;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.List;
import java.util.Vector;

/**
 * Created by Adhamkh on 2017-08-31.
 */

public class RequestUrlConnection {

    public List<Pair<String, String>> Properties;

    public int timeout = 10000;







    public static Bitmap getBitmapFromString(String jsonString) {
        byte[] decodedString = Base64.decode(jsonString, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }

    public void addProperty(Pair<String, String> pair) {
        if (Properties == null)
            Properties = new Vector<>();
        Properties.add(pair);
    }

    public void addProperties(Pair<String, String>... pairs) {
        if (Properties == null)
            Properties = new Vector<>();
        for (Pair<String, String> itm : pairs)
            Properties.add(itm);
    }

    public List<Pair<String, String>> getProperties() {
        return Properties;
    }

    public void setProperties(List<Pair<String, String>> properties) {
        Properties = properties;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }




}
