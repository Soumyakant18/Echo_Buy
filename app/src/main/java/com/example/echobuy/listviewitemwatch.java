package com.example.echobuy;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class listviewitemwatch extends AppCompatActivity {

    private ListView listViewwatch;
    private CustomAdapter customAdapter;

    private pojo[] items = {
            new pojo("Pebble", R.drawable.watch1, "smart watch", "RS: 14999"),
            new pojo("Fossil", R.drawable.watch2, "Casual watch", "RS: 23999"),
            new pojo("Apple", R.drawable.watch3, "Smart watch", "RS: 2999"),
            new pojo("Sonata", R.drawable.watch4, "gold watch", "RS: 3999"),
            new pojo("Leaf", R.drawable.watch5, "Smart watch", "RS: 999"),
            new pojo("RADO", R.drawable.watch6, "Digital watch", "RS: 62999"),
            new pojo("Fossil", R.drawable.watch7, "Stripped watch", "RS: 45999"),
            new pojo("Apple", R.drawable.watch8, "Bluettoth watch", "RS: 23999")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_listviewitemwatch);

        listViewwatch = findViewById(R.id.listmadewatch);
        customAdapter = new CustomAdapter(this, items);

        // Set the adapter for the ListView
        listViewwatch.setAdapter(customAdapter);
    }
}