package com.textile.markeet.data.retrofit;

import com.textile.markeet.data.models.signin.SigninDataContainer;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ServiceApi {

    @GET
    Call<String> testResponse(@Url String url);

    @POST("mobile-login.php")
    Call<SigninDataContainer> signinForm(@QueryMap Map<String, String> parameters);
}
