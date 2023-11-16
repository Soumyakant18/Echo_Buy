package com.example.echobuy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
}
