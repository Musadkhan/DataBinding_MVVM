package com.example.databinding_mvvm.retrofit;

import com.example.databinding_mvvm.model.UserInfoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIServices {

    @GET("posts")
    Call<List<UserInfoModel>> getUserInformation();

    @POST
    Call<UserInfoModel> postUserInfo(@Body UserInfoModel userInfoModel);

}
