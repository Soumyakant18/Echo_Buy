package com.example.echobuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Signup_activity extends AppCompatActivity {

    TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_signup);

        TextView textView = (TextView)findViewById (R.id.already);



        // Replace 'your_video' with the name of your video file in res/raw



        textView.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Signup_activity.this, loginactivity.class);
                startActivity (intent);
            }
        });
    }
}