package com.son.jawad.ui_widgets.Activities.NetworkingActivities.Retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.son.jawad.ui_widgets.Models.Client;
import com.son.jawad.ui_widgets.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Adhamkh on 2017-09-02.
 */

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit_layout);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.117.0.167/RoyalApplication/")
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        service.listRepos("adhamkhwaldeh@gmail.com", "123456").enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                Client client = response.body();
                Log.v("", "");
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Log.v("", "");
            }
        });


    }

}
