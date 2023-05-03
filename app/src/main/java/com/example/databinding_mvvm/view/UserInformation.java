package com.example.databinding_mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.databinding_mvvm.R;
import com.example.databinding_mvvm.adapter.UserInfoAdapter;
import com.example.databinding_mvvm.model.UserInfoModel;
import com.example.databinding_mvvm.viewmodels.UserDataViewModel;

import java.util.List;

public class UserInformation extends AppCompatActivity {

    RecyclerView rv;
    List<UserInfoModel> userInfoModels;
    UserDataViewModel userDataViewModel;
    UserInfoAdapter userInfoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);


        rv = findViewById(R.id.userRv);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        userInfoAdapter=new UserInfoAdapter(userInfoModels);
        rv.setAdapter(userInfoAdapter);


        //userDataViewModel = ViewModelProviders.of(this).get(UserDataViewModel.class);
        userDataViewModel = new ViewModelProvider(this).get(UserDataViewModel.class);
        userDataViewModel.getUserInformationObserver().observe(this, new Observer<List<UserInfoModel>>() {
            @Override
            public void onChanged(List<UserInfoModel> userInfoModels) {
                userInfoModels = userInfoModels;
                userInfoAdapter.updateUserList(userInfoModels);

            }
        });
        userDataViewModel.makeApiCall();
    }
}