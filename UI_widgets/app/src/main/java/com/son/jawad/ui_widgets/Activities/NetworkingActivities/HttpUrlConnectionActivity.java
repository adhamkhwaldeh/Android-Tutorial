package com.son.jawad.ui_widgets.Activities.NetworkingActivities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Filterable;
import android.widget.ImageView;

import com.son.jawad.ui_widgets.Models.Client;
import com.son.jawad.ui_widgets.Models.FileResult;
import com.son.jawad.ui_widgets.Models.Register;
import com.son.jawad.ui_widgets.Networks.AsyncRequest.GetRequest;
import com.son.jawad.ui_widgets.Networks.AsyncRequest.PostRequest;
import com.son.jawad.ui_widgets.Networks.AsyncRequest.UploadImage;
import com.son.jawad.ui_widgets.Networks.RequestCallbackListener;
import com.son.jawad.ui_widgets.Networks.ResponseState;
import com.son.jawad.ui_widgets.Networks.UrlResponse;
import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-08-31.
 */

public class HttpUrlConnectionActivity extends AppCompatActivity {
    public Button uploadbtn;
    public ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.httpurlconnection_layout);
        uploadbtn = (Button) findViewById(R.id.uploadbtn);
        image = (ImageView) findViewById(R.id.image);

             new GetRequest<>("http://10.117.0.167/RoyalApplication/api/signin/adhamkhwaldeh@gmail.com/123456",
                10000, Client.class,
                new RequestCallbackListener<Client>() {
                    @Override
                    public void onPreRequest() {
                        Log.v("", "");
                    }

                    @Override
                    public void onPostRequest(UrlResponse<Client> urlResponse) {
                        if (urlResponse.responseState.responseState == ResponseState.RESPONSE_SUCCESS) {
                            Client client = urlResponse.getResponseObject();
                            if (client.getOk()) {
                                String name = client.Fullname;
                                String password = client.getPhone();
                            } else {

                            }
                        }
                        Log.v("", "");
                    }
                });//.execute();

        Register register = new Register();
        register.fullname = "adhamkhwaldeh";
        register.email = "adhamkhwaldeh@gmail.com";
        register.password = "123456";
        register.phone = "0943915633";

        new PostRequest<Client>("http://10.117.0.167/RoyalApplication/api/signup", register, 10000, Client.class,
                new RequestCallbackListener<Client>() {
                    @Override
                    public void onPreRequest() {
                        Log.v("", "");
                    }

                    @Override
                    public void onPostRequest(UrlResponse<Client> urlResponse) {
                        Log.v("", "");
                    }
                }).execute();

        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(photo);
            new UploadImage<FileResult>("http://10.117.0.167/RoyalApplication/api/UploadPhoto", photo, FileResult.class,
                    new RequestCallbackListener<FileResult>() {
                        @Override
                        public void onPreRequest() {
                            Log.v("aa", "aa");
                        }

                        @Override
                        public void onPostRequest(UrlResponse<FileResult> urlResponse) {
                            FileResult fileResult = urlResponse.getResponseObject();

                            Log.v("aa", "aa");
                        }
                    }).execute();
        }

    }
}
