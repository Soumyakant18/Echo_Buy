package com.example.echobuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class listviewitemshoe extends AppCompatActivity {
    private ListView listViewshoe;
    private CustomAdapter customAdapter;

    private pojo[] items = {
            new pojo("PUMA", R.drawable.shoe1, "Puma Smash Valc Sneakers", "RS : 4999.00"),
            new pojo("PUMA", R.drawable.shoe2, "Fendi Flow Sneakers for women", "RS : 1999.00"),
            new pojo("PUMA", R.drawable.shoe3, "Ferrari Edition Shoes", "RS : 9999.00"),
            new pojo("Action", R.drawable.shoe4, "Casual Slippers", "RS : 199.00"),
            new pojo("SPARKX", R.drawable.shoe10, "Belt Scandals for men", "RS : 599.00"),
            new pojo("BACA BUCCI", R.drawable.shoe8, "Brown Formal Shoes", "RS : 1999.00"),
            new pojo("BACA BUCCI", R.drawable.shoe7, "Black Formal Shoes", "RS : 1999.00"),
            new pojo("SPARKX", R.drawable.shoe9, "Sparks belt shoes", "RS : 499.00"),
            new pojo("FILA", R.drawable.shoe5, "Regular Slippers", "RS : 199.00"),
            new pojo("CROCS", R.drawable.shoe6, "White Crocs ", "RS : 2099.00")
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_listviewitemshoe);

        listViewshoe = findViewById(R.id.listmadeshoe);
        customAdapter = new CustomAdapter(this, items);

        // Set the adapter for the ListView
        listViewshoe.setAdapter(customAdapter);
        listViewshoe.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                pojo selectedItem = items[position];

                // Start TestActivity and pass the selected item's data
                Intent intent = new Intent(listviewitemshoe.this, testactivity.class);
                intent.putExtra("SELECTED_ITEM", selectedItem);
                startActivity(intent);
            }

        });
    }
}