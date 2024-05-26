package com.example.echobuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class womencategory extends AppCompatActivity {

    private ListView womencate;

    private CustomAdapter customAdapter;

    private pojo[] items = {
            new pojo("LEVI'S", R.drawable.pant5, "loose plazo", "RS: 1999"),
            new pojo("NIKE", R.drawable.shoe2, "pro runner", "RS: 9999"),
            new pojo("STANZA", R.drawable.toy1, "Bunny", "RS: 239"),
            new pojo("STANZA", R.drawable.toys2, "Baby Elephant", "RS: 99"),
            new pojo("FIRE BOLT", R.drawable.watch5, "Digital watch", "RS: 2399"),
            new pojo("SKYBAGS", R.drawable.bag5, "hand bag ", "RS: 899"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_womencategory);

        womencate = findViewById(R.id.categorywomen);
        customAdapter = new CustomAdapter(this, items);

        // Set the adapter for the ListView
        womencate.setAdapter(customAdapter);
        womencate.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                pojo selectedItem = items[position];

                // Start TestActivity and pass the selected item's data
                Intent intent = new Intent(womencategory.this, testactivity.class);
                intent.putExtra("SELECTED_ITEM", selectedItem);
                startActivity(intent);
            }
        });
    }
}