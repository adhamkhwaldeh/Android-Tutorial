package com.son.jawad.ui_widgets.Activities.NetworkingActivities.Retrofit;

import com.son.jawad.ui_widgets.Models.Client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

    @GET("api/signin/{email}/{password}")
    Call<Client> listRepos(@Path("email") String email,@Path("password") String password);

}