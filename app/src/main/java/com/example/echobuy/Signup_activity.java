package com.example.echobuy;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Signup_activity extends AppCompatActivity {

    TextView textView;
    private ImageView imageView;
    private EditText usernameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_signup);

        TextView textView = (TextView)findViewById (R.id.already);

        dbHelper = new DatabaseHelper(this);

        // Replace 'your_video' with the name of your video file in res/raw
        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.Email);
        passwordEditText = findViewById(R.id.putpassword);
        confirmPasswordEditText = findViewById(R.id.confirmpassord);
        Button registerButton = findViewById(R.id.btnregister);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user input data
                String username = usernameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                // Check if passwords match
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(Signup_activity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Save data to the database
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("username", username);
                values.put("email", email);
                values.put("password", password);

                long newRowId = db.insert("Users", null, values);

                if (newRowId != -1) {
                    Toast.makeText(Signup_activity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                    // You might navigate to another activity or perform other actions upon successful signup
                } else {
                    Toast.makeText(Signup_activity.this, "Failed to register user", Toast.LENGTH_SHORT).show();
                }

                db.close(); // Close the database connection
            }
        });
        textView.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Signup_activity.this, loginactivity.class);
                startActivity (intent);
            }
        });
    }
}