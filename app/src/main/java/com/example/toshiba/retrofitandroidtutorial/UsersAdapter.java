package com.example.toshiba.retrofitandroidtutorial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Toshiba on 03/10/2018.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private Context context;
    private List<User> userList;

    public UsersAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public UsersAdapter.UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.recyclerview_user, parent, false);

        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersAdapter.UsersViewHolder holder, int position) {
        User user = userList.get(position);

        holder.textViewName.setText(user.getName());
        holder.textViewEmail.setText(user.getEmail());
        holder.textViewSchool.setText(user.getSchool());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    class UsersViewHolder extends RecyclerView.ViewHolder{

        TextView textViewEmail;
        TextView textViewName;
        TextView textViewSchool;

        public UsersViewHolder(View itemView) {
            super(itemView);

            textViewEmail = itemView.findViewById(R.id.text_view_email);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewSchool = itemView.findViewById(R.id.text_view_school);
        }
    }
}
