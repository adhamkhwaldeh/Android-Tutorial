package com.son.jawad.ui_widgets.Activities.NetworkingActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.son.jawad.ui_widgets.Models.Client;
import com.son.jawad.ui_widgets.MyApplication;
import com.son.jawad.ui_widgets.R;

import org.json.JSONObject;

/**
 * Created by Adhamkh on 2017-09-02.
 */

public class VolleyActivity extends AppCompatActivity {
    String tag_json_obj = "json_obj_req";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley_layout);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                "http://10.117.0.167/RoyalApplication/api/signin/adhamkhwaldeh@gmail.com/123456", null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        Client client = gson.fromJson(response.toString(), Client.class);
                        if (client.getOk()) {

                        } else {

                        }
                        Log.d("BB", response.toString());
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("AA", "Error: " + error.getMessage());
                    }
                });
        MyApplication.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

    }
}
