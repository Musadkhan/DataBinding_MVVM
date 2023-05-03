package com.example.databinding_mvvm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databinding_mvvm.R;
import com.example.databinding_mvvm.model.UserInfoModel;

import java.util.List;


public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.myviewholder> {

    List<UserInfoModel> userInfo;

    public UserInfoAdapter(@NonNull List<UserInfoModel> userInfo) {
        this.userInfo = userInfo;
    }

    public void updateUserList(List<UserInfoModel> userInfoModels)
    {
        this.userInfo = userInfoModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserInfoAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_info_single_item,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserInfoAdapter.myviewholder holder, int position) {

        holder.titleTxt.setText(userInfo.get(position).getTitle());
        holder.descTxt.setText(userInfo.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        if(userInfo!=null) {
            return userInfo.size();
        }else {
            return 0;
        }

    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView titleTxt,descTxt;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            descTxt = itemView.findViewById(R.id.descTxt);
        }
    }
}
