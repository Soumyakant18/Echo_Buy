package com.example.echobuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class listviewitempant extends AppCompatActivity {

    private ListView listViewpant;
    private CustomAdapter customAdapter;

    private pojo[] items = {
            new pojo("ROADSTER", R.drawable.pant7, "White Trousers for Men", "RS : 2999.00"),
            new pojo("DNMX", R.drawable.pant6, "Red Trousers", "RS : 599.00"),
            new pojo("SPARKY", R.drawable.pant5, "Korean Styled pants for women", "RS : 2099.00"),
            new pojo("KILLER", R.drawable.pant4, "Brown joggers", "RS : 599.00"),
            new pojo("ROADSTER", R.drawable.pant1, "Black Trousers", "RS : 899.00"),
            new pojo("KILLER", R.drawable.pant2, "Grey Trousers", "RS : 599.00"),
            new pojo("DNMX", R.drawable.pant3, "Green Trousers", "RS : 599.00"),
            new pojo("ROADSTER", R.drawable.pant8, "Grey Trousers", "RS : 599.00"),
            new pojo("TURTLE", R.drawable.pant9, "Green Trousers", "RS : 599.00"),
            new pojo("SPARKY", R.drawable.pant10, "Plain joggers", "RS : 599.00")

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_listviewitempant);

        listViewpant = findViewById(R.id.listmadepants);
        customAdapter = new CustomAdapter(this, items);

        // Set the adapter for the ListView
        listViewpant.setAdapter(customAdapter);
        listViewpant.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                pojo selectedItem = items[position];

                // Start TestActivity and pass the selected item's data
                Intent intent = new Intent(listviewitempant.this, testactivity.class);
                intent.putExtra("SELECTED_ITEM", selectedItem);
                startActivity(intent);
            }

        });
    }
}