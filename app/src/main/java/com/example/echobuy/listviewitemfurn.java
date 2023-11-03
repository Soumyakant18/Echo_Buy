package com.example.echobuy;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class listviewitemfurn extends AppCompatActivity {

    private ListView listViewfurn;
    private CustomAdapter customAdapter;
    private pojo[] items = {
            new pojo("Item 1", R.drawable.echo_cart_icon, "Text for Item 1", "More text for Item 1"),
            new pojo("Item 2", R.drawable.echo_cart_icon, "Text for Item 2", "More text for Item 2"),
            new pojo("Item 3", R.drawable.echo_cart_icon, "Text for Item 3", "More text for Item 3")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_listviewitemfurn);

        listViewfurn = findViewById(R.id.listmadefurn);
        customAdapter = new CustomAdapter(this, items);

        // Set the adapter for the ListView
        listViewfurn.setAdapter(customAdapter);
    }
}