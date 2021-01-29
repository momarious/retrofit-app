package com.example.toshiba.retrofitandroidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailET;
    private EditText passwordET;
    private EditText nameET;
    private EditText schoolET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailET = findViewById(R.id.email);
        passwordET = findViewById(R.id.password);
        nameET = findViewById(R.id.name);
        schoolET = findViewById(R.id.school);

        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.signup).setOnClickListener(this);
    }

    private void userSignUp() {

        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();
        String name = nameET.getText().toString().trim();
        String school = schoolET.getText().toString().trim();

        if (email.isEmpty()) {
            emailET.setError("Email is required");
            emailET.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailET.setError("Enter an email valid");
            emailET.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordET.setError("Password is required");
            passwordET.requestFocus();
            return;
        }

        if (password.length() < 6) {
            passwordET.setError("Password length should be at least 6 character");
            passwordET.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            nameET.setError("Name is required");
            nameET.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            schoolET.setError("School is required");
            schoolET.requestFocus();
            return;
        }

        Call<DefaultResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .createUser(email, password, name, school);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.code() == 201) {
                    DefaultResponse defaultResponse = response.body();
                    Toast.makeText(MainActivity.this, defaultResponse.getMessage(), Toast.LENGTH_LONG).show();
                } else if (response.code() == 422) {
                    DefaultResponse defaultResponse = response.body();
                    Toast.makeText(MainActivity.this, "User already created", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (SharedPreferencesManager
                .getInstance(this)
                .isLoggedIn()) {

            Intent intent = new Intent(this, ProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);

        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signup:
                userSignUp();
                break;

            case R.id.login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
