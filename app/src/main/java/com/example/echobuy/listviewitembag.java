package com.example.echobuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class listviewitembag extends AppCompatActivity {

    private ListView listViewbag;
    private CustomAdapter customAdapter;

    private pojo[] items = {
            new pojo("SAFARI", R.drawable.bagsafari, "Safari new Arrival", "RS : 2999.00"),
            new pojo("DNMX", R.drawable.bag2, "Smart Bag", "RS : 8999.00"),
            new pojo("SPARKY", R.drawable.bag1, "Trek bag", "RS : 2099.00"),
            new pojo("SAFARI", R.drawable.bag3, "Smart Bag", "RS : 8599.00"),
            new pojo("SAFARI", R.drawable.bagsafari10, "Safari new Arrival", "RS : 399.00"),
            new pojo("KILLER", R.drawable.bag4, "easy Hand Bag for Travel", "RS : 999.00"),
            new pojo("DNMX", R.drawable.bag5, "Fancy Hand Bag ", "RS : 199.00"),
            new pojo("LUNAR", R.drawable.bag6, "School and College Bag", "RS : 1099.00"),
            new pojo("LUNAR", R.drawable.bag7, "School and College Bag", "RS : 2799.00"),
            new pojo("LUNAR", R.drawable.bag8, "School and College Bag", "RS : 1059.00")
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_listviewitembag);

        listViewbag = findViewById(R.id.listmadebag);
        customAdapter = new CustomAdapter(this, items);

        // Set the adapter for the ListView
        listViewbag.setAdapter(customAdapter);
        listViewbag.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                pojo selectedItem = items[position];

                // Start TestActivity and pass the selected item's data
                Intent intent = new Intent(listviewitembag.this, testactivity.class);
                intent.putExtra("SELECTED_ITEM", selectedItem);
                startActivity(intent);
            }

        });
    }
}