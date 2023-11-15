package com.example.echobuy;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class listviewitem extends AppCompatActivity {

    private ListView listView;
    private CustomAdapter customAdapter;

    private pojo[] items = {
            new pojo("WROGN", R.drawable.shirt1, "Half Neck Floral Printed Shirt", "RS : 2099.00"),
            new pojo("ROADSTER", R.drawable.shirt2, "Blue Printed Casual Shirt", "RS: 899.00"),
            new pojo("ONE8", R.drawable.shirt9, "Yellow Hoodie ", "RS: 1099.00"),
            new pojo("LEVI'S", R.drawable.shirt5, "Plain white t-shirt for men", "RS: 899.00"),
            new pojo("ONE8", R.drawable.shirt8, "Classic White Hoodie for men", "RS: 1999.00"),
            new pojo("TECHNO", R.drawable.shirt7, "Sports Wear for men", "RS: 259.00"),
            new pojo("TURTLE", R.drawable.shirt3, "Blue Printed Casuals Shirt", "RS: 1299.00"),
            new pojo("US POLO", R.drawable.shirt4, " Green Polo Shirt", "RS: 499.00"),
            new pojo("ROADSTER", R.drawable.shirt6, "Avengers Hoodie ", "RS: 2999.00"),
            new pojo("PUMA", R.drawable.shirt10, "PumaxBMW T-shirt", "RS: 1999.00")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewitem);

        listView = findViewById(R.id.listmade);
        customAdapter = new CustomAdapter(this, items);

        // Set the adapter for the ListView
        listView.setAdapter(customAdapter);
    }
}
