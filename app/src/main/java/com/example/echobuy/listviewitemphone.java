package com.example.echobuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class listviewitemphone extends AppCompatActivity {

    private ListView listViewphone;
    private CustomAdapter customAdapter;

    private pojo[] items = {
            new pojo("Redmi", R.drawable.phone1, "12 pro max", "RS: 12999"),
            new pojo("Redmi", R.drawable.phone2, "11 pro", "RS: 18999"),
            new pojo("Vivo", R.drawable.phone4, "Y25 5g", "RS: 23999"),
            new pojo("iqoo", R.drawable.phone5, "z6 5g", "RS: 20999"),
            new pojo("Realme", R.drawable.phone6, "narzo 12", "RS: 12399"),
            new pojo("Apple", R.drawable.phone7, "15 pro max", "RS: 127899"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_listviewitemphone);

        listViewphone = findViewById(R.id.listmadephone);
        customAdapter = new CustomAdapter(this, items);

        // Set the adapter for the ListView
        listViewphone.setAdapter(customAdapter);
        listViewphone.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                pojo selectedItem = items[position];

                // Start TestActivity and pass the selected item's data
                Intent intent = new Intent(listviewitemphone.this, testactivity.class);
                intent.putExtra("SELECTED_ITEM", selectedItem);
                startActivity(intent);
            }

        });
    }
}