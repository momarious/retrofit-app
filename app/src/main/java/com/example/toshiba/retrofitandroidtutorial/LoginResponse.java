package com.example.toshiba.retrofitandroidtutorial;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Toshiba on 02/10/2018.
 */

public class LoginResponse {

    @SerializedName("error") private boolean error;
    @SerializedName("message") private String message;
    @SerializedName("user") private User user;

    public LoginResponse(boolean error, String message, User user) {
        this.error = error;
        this.message = message;
        this.user = user;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
