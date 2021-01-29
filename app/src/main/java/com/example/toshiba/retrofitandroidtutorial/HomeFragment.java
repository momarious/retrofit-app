package com.example.toshiba.retrofitandroidtutorial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Toshiba on 03/10/2018.
 */

public class HomeFragment extends Fragment {

    private TextView textViewEmail;
    private TextView textViewName;
    private TextView textViewSchool;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewEmail = view.findViewById(R.id.text_view_email);
        textViewName = view.findViewById(R.id.text_view_name);
        textViewSchool = view.findViewById(R.id.text_view_school);


        textViewEmail
                .setText(SharedPreferencesManager
                        .getInstance(getActivity())
                        .getUser()
                        .getEmail()
                );

        textViewName
                .setText(SharedPreferencesManager
                        .getInstance(getActivity())
                        .getUser()
                        .getName()
                );

        textViewSchool
                .setText(SharedPreferencesManager
                        .getInstance(getActivity())
                        .getUser()
                        .getSchool()
                );
    }

}
