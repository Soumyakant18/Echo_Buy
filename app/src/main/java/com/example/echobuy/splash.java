package com.example.echobuy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {

    // Duration of the splash screen in milliseconds
    private static final long SPLASH_DURATION = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an Intent to start the main activity
                Intent mainIntent = new Intent(splash.this, MainActivity.class);
                startActivity(mainIntent);

                // Close the splash activity
                finish();
            }
        }, 2000);
    }
}
