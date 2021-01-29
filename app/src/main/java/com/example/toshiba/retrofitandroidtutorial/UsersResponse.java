package com.example.toshiba.retrofitandroidtutorial;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Toshiba on 03/10/2018.
 */

public class UsersResponse {

    private boolean error;
    private List<User> users;

    public UsersResponse(boolean error, List<User> user) {
        this.error = error;
        this.users = user;
    }

    public boolean isError() {
        return error;
    }

    public List<User> getListUsers() {
        return users;
    }
}
