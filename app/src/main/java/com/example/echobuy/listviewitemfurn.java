package com.example.echobuy;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class listviewitemfurn extends AppCompatActivity {

    private ListView listViewfurn;
    private CustomAdapter customAdapter;
    private pojo[] items = {
            new pojo("Neel kamal", R.drawable.sofa1, "dinning table", "RS: 1299"),
            new pojo("century", R.drawable.sofa2, "study desk", "RS: 1799"),
            new pojo("century", R.drawable.sofa3, "powder table", "RS: 7299"),
            new pojo("IKEA", R.drawable.sofa4, "sofa table", "RS: 4579"),
            new pojo("century", R.drawable.sofa5, "tv set", "RS: 999"),
            new pojo("IKEA", R.drawable.sofa6, "sofa table", "RS: 4229"),
            new pojo("Neel kamal", R.drawable.sofa7, "coffee table", "RS: 3699"),
            new pojo("Lotus", R.drawable.sofa8, "stool", "RS: 822")

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