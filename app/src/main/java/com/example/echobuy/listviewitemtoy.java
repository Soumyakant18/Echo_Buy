package com.example.echobuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class listviewitemtoy extends AppCompatActivity {

    private ListView listviewtoy;
    private CustomAdapter customAdapter;

    private pojo[] items = {
            new pojo("pantaloons", R.drawable.toy1, "soft foam", "Rs : 399"),
            new pojo("pantaloons", R.drawable.toys2, "soft foam", "Rs : 499"),
            new pojo("hot wheels", R.drawable.toys3, "car toy", "Rs : 299"),
            new pojo("neel", R.drawable.toys4, "remote car", "Rs : 379"),
            new pojo("hot wheels", R.drawable.toy5, "remote car", "Rs : 199"),
            new pojo("pantaloons", R.drawable.toy, "soft foam", "Rs : 599"),
            new pojo("pantaloons", R.drawable.toys2, "soft foam", "Rs : 339")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_listviewitemtoy);


        listviewtoy = findViewById(R.id.listmadetoy);
        customAdapter = new CustomAdapter(this, items);

        // Set the adapter for the ListView
        listviewtoy.setAdapter(customAdapter);
        listviewtoy.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                pojo selectedItem = items[position];

                // Start TestActivity and pass the selected item's data
                Intent intent = new Intent(listviewitemtoy.this, testactivity.class);
                intent.putExtra("SELECTED_ITEM", selectedItem);
                startActivity(intent);
            }

        });
    }
}