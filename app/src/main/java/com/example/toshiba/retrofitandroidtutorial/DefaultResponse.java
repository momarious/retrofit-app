package com.example.toshiba.retrofitandroidtutorial;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Toshiba on 02/10/2018.
 */

public class DefaultResponse {

    @SerializedName("error") private boolean error;
    @SerializedName("message") private String message;

    public DefaultResponse(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

}
