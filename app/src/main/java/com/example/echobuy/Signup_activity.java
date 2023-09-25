package com.example.echobuy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Signup_activity extends AppCompatActivity {

    TextView textView;
    private VideoView videoViewone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_signup);

        TextView textView = (TextView)findViewById (R.id.already);

        videoViewone = findViewById (R.id.videoViewone);

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.sign; // Replace 'your_video' with the name of your video file in res/raw
        Uri uri = Uri.parse(videoPath);
        videoViewone.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoViewone);
        videoViewone.setMediaController(mediaController);

        videoViewone.start();
        textView.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Signup_activity.this, loginactivity.class);
                startActivity (intent);
            }
        });
    }
}