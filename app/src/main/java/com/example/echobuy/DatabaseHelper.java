package com.example.echobuy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName = "Signup.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, databaseName, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase mydb) {
        mydb.execSQL("CREATE TABLE IF NOT EXISTS Users (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT, email TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb, int i, int i1) {
        mydb.execSQL("DROP TABLE IF EXISTS Users");
        onCreate(mydb);
    }
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Users", null);

        if (cursor.moveToFirst()) {
            int usernameIndex = cursor.getColumnIndex("username");
            int emailIndex = cursor.getColumnIndex("email");
            int passwordIndex = cursor.getColumnIndex("password");

            // Check if the columns exist in the Cursor
            if (usernameIndex == -1 || emailIndex == -1 || passwordIndex == -1) {
                // Log an error or handle the situation where columns are not found
                Log.e("CursorError", "One or more columns not found in the Cursor.");
            } else {
                do {
                    // Retrieve values from the Cursor using the column indices
                    String username = cursor.getString(usernameIndex);
                    String email = cursor.getString(emailIndex);
                    String password = cursor.getString(passwordIndex);

                    // Create a User object and add it to the list
                    User user = new User(username, email, password);
                    userList.add(user);

                } while (cursor.moveToNext());
            }
        } else {

        }


        cursor.close();

        return userList;
    }
}
