package com.example.echobuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class testactivity extends AppCompatActivity {

    private OrderHelper orderHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testactivity);

        orderHelper = new OrderHelper(this);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("SELECTED_ITEM")) {
            pojo selectedItem = (pojo) intent.getSerializableExtra("SELECTED_ITEM");
            if (selectedItem != null) {
                ImageView productImageView = findViewById(R.id.imageViewone);
                TextView titleTextView = findViewById(R.id.textViewone);
                TextView descriptionTextView = findViewById(R.id.textViewtwo);
                TextView priceTextView = findViewById(R.id.textViewthree);
                Button button = findViewById(R.id.submit);

                titleTextView.setText(selectedItem.getTitle());
                descriptionTextView.setText(selectedItem.getText2());
                priceTextView.setText(selectedItem.getText3());


                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String image = String.valueOf(selectedItem.getImageResource());
                        String name = selectedItem.getTitle();
                        String description = selectedItem.getText2();
                        String price = selectedItem.getText3();

                        Order order = new Order(image, name, description, price);
                        orderHelper.addOrder(order);


                        Toast.makeText(testactivity.this, "Your order will deliver soon", Toast.LENGTH_SHORT).show();
                    }
                });

                Glide.with(this)
                        .load(selectedItem.getImageResource())
                        .into(productImageView);
            }
        }
    }
}
