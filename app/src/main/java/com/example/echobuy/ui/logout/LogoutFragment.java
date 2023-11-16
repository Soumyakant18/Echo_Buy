package com.example.echobuy.ui.logout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.echobuy.R;
import com.example.echobuy.loginactivity;

public class LogoutFragment extends Fragment {


    private Button btnMoveToActivity;
    public static LogoutFragment newInstance() {
        return new LogoutFragment ( );
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_account, container, false);

        // Initialize button
        btnMoveToActivity = root.findViewById(R.id.btnacc);

        // Set OnClickListener for the button
        btnMoveToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), loginactivity.class);
                startActivity(intent);
            }
        });

        return root;
    }




}