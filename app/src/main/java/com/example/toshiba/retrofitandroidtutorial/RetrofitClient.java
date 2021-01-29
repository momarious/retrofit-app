package com.example.toshiba.retrofitandroidtutorial;

import android.util.Base64;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Toshiba on 01/10/2018.
 */

public class RetrofitClient {

    private static final String AUTH = "Basic " + Base64.encodeToString(("root:root").getBytes(), Base64.NO_WRAP);
    private static final String BASE_URL = "http://10.0.2.2:80/MyApi/public/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request request = chain.request();

                                Request.Builder builder = request.newBuilder()
                                        .addHeader("Authorization", AUTH)
                                        .method(request.method(), request.body());

                                return chain.proceed(builder.build());
                            }
                        }
                )
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public Api getApi() {

        return retrofit.create(Api.class);

    }
}
