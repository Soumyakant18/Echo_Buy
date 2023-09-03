package com.example.echobuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginactivity extends AppCompatActivity {

        EditText editTextname,editTextpassword;
Button button;
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_loginactivity);
        EditText editTextname=(EditText) findViewById (R.id.loginuser);
        EditText editTextpassword = (EditText) findViewById (R.id.logpassword);
            Button button =(Button) findViewById (R.id.btnlogin);
            textView =(TextView) findViewById (R.id.logintext);


     button.setOnClickListener (new View.OnClickListener ( ) {
         @Override
         public void onClick(View view) {
             String username = editTextname.getText().toString();
             String passwordInput = editTextpassword.getText().toString();


             if (!username.matches("[a-zA-Z]+")) {

                 Toast.makeText(loginactivity.this, "Invalid username.", Toast.LENGTH_SHORT).show();
             } else if (!passwordInput.matches("[0-9]+")) {

                 Toast.makeText(loginactivity.this, "Invalid password.", Toast.LENGTH_SHORT).show();
             } else {
                 Toast.makeText (loginactivity.this, "login succesfully", Toast.LENGTH_SHORT).show ( );
                 Intent intent = new Intent (getApplicationContext (), menupage_activity.class);
                 startActivity (intent);
             }

         }
     });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             Intent intent = new Intent (loginactivity.this, Signup_activity.class);
             startActivity (intent);
            }
        });

    }
}