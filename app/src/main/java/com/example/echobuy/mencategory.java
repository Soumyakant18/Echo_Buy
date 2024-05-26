package com.example.echobuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class mencategory extends AppCompatActivity {

    private ListView mencate;

    private CustomAdapter customAdapter;

    private pojo[] items = {
            new pojo("Levi's", R.drawable.shirt2, "blue soft cotton ", "RS: 1999"),
            new pojo("Roadster", R.drawable.pant7, "Grey cotton", "RS: 999"),
            new pojo("ONE8", R.drawable.shirt9, "Yellow Hoodie ", "RS: 3999"),
            new pojo("PUMA", R.drawable.shoe3, "PUMA X Ferrari", "RS: 2999"),
            new pojo("Rolex", R.drawable.watch7, "articuno", "RS: 12399"),
            new pojo("Supra", R.drawable.bag2, "Smart Bags", "RS: 1899"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mencategory);

        mencate = findViewById(R.id.categorymen);
        customAdapter = new CustomAdapter(this, items);

        // Set the adapter for the ListView
        mencate.setAdapter(customAdapter);
        mencate.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                pojo selectedItem = items[position];

                // Start TestActivity and pass the selected item's data
                Intent intent = new Intent(mencategory.this, testactivity.class);
                intent.putExtra("SELECTED_ITEM", selectedItem);
                startActivity(intent);
            }
        });
    }
}