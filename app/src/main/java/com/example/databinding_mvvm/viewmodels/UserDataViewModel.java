package com.example.databinding_mvvm.viewmodels;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.databinding_mvvm.model.UserInfoModel;
import com.example.databinding_mvvm.retrofit.APIServices;
import com.example.databinding_mvvm.retrofit.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDataViewModel extends ViewModel {

    Context context;

    public UserDataViewModel(Context context) {
        this.context = context;
    }

    private MutableLiveData<List<UserInfoModel>> userList;

    public UserDataViewModel()
    {
        userList = new MutableLiveData<>();
    }

    public MutableLiveData<List<UserInfoModel>> getUserInformationObserver()
    {
        return userList;
    }

    public void makeApiCall()
    {
        APIServices apiServices = RetrofitInstance.getRetrofitClient().create(APIServices.class);
        Call<List<UserInfoModel>> call = apiServices.getUserInformation();
        call.enqueue(new Callback<List<UserInfoModel>>() {
            @Override
            public void onResponse(Call<List<UserInfoModel>> call, Response<List<UserInfoModel>> response) {
                userList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<UserInfoModel>> call, Throwable t) {
                userList.postValue(null);
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
