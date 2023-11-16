package com.example.echobuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class perfumecategory extends AppCompatActivity {

    private ListView perfumecate;

    private CustomAdapter customAdapter;

    private pojo[] items = {
            new pojo("DENVER", R.drawable.perfume1, "HAMILTON ", "RS: 1999"),
            new pojo("BYREDO", R.drawable.perfume2, "MIXED EMOTIONS", "RS: 999"),
            new pojo("FOGG", R.drawable.perfume3, "ROYAL ", "RS: 3999"),
            new pojo("CHANEL", R.drawable.perfume4, "EASTERDAN", "RS: 2999"),
            new pojo("YOURNAME", R.drawable.perfume5, "articuno", "RS: 12399"),
            new pojo("YOURNAME", R.drawable.perfume7, "HAPPY BIRTHDAY", "RS: 1899"),
            new pojo("SKIN", R.drawable.perfume8, "TITAN", "RS: 1899"),
            new pojo("CHANEL", R.drawable.perfume9, "EAU DE PERFUME", "RS: 1899"),
            new pojo("SCUBA", R.drawable.perfume10, "BASECAMP", "RS: 1899"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfumecategory);

        perfumecate = findViewById(R.id.categoryperfume);
        customAdapter = new CustomAdapter(this, items);

        // Set the adapter for the ListView
        perfumecate.setAdapter(customAdapter);
    }
}