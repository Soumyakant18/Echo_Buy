package com.example.echobuy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class loginactivity extends AppCompatActivity {

        EditText editTextname,editTextpassword;
Button button;
    private DatabaseHelper dbHelper;
private TextView textViewlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_loginactivity);
        dbHelper = new DatabaseHelper(this);

        EditText editTextname=(EditText) findViewById (R.id.loginuser);
        EditText editTextpassword = (EditText) findViewById (R.id.logpassword);
            Button button =(Button) findViewById (R.id.btnlogin);
            textViewlogin =(TextView) findViewById (R.id.logintext);

     button.setOnClickListener (new View.OnClickListener ( ) {
         @Override
         public void onClick(View v) {
             String username = editTextname.getText().toString().trim();
             String password = editTextpassword.getText().toString().trim();


             if (validateLogin(username, password)) {

                 Toast.makeText(loginactivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                 Intent intent = new Intent(loginactivity.this, menupage_activity.class);
                 startActivity(intent);
                 finish();
             } else {

                 Toast.makeText(loginactivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
             }
         }
     });

      textViewlogin.setOnClickListener (new View.OnClickListener ( ) {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent (loginactivity.this, Signup_activity.class);
              startActivity (intent);
          }
      });
    }
    private boolean validateLogin(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {"username", "password"};
        S0tring selection = "username = ? AND password = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query("Users", projection, selection, selectionArgs, null, null, null);

        boolean isValid = cursor.moveToFirst();
        cursor.close();
        db.close();
        return isValid;
    }
}