package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    ArrayList<User> mUserList;
    LayoutInflater inflater;

    public UserAdapter(Context context, ArrayList<User> users) {
        inflater = LayoutInflater.from(context);
        this.mUserList = users;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recyclerviewlayout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        User selectedProduct = mUserList.get(position);
        holder.setData(selectedProduct, position);
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView userName, password;
        ImageView userImage, deleteproduct;

        public MyViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.userName);
            password = (TextView) itemView.findViewById(R.id.password);
            userImage = (ImageView) itemView.findViewById(R.id.userImage);
        }

        public void setData(User selectedProduct, int position) {

            this.userName.setText(selectedProduct.getUserName());
            this.password.setText(selectedProduct.getPassword());
            this.userImage.setImageResource(selectedProduct.getImage());
        }

        @Override
        public void onClick(View v) {
        }
    }
}