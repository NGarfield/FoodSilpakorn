package com.example.foodsilpakorn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantsDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_detail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int image = intent.getIntExtra("image",0);
        String type = intent.getStringExtra("type");
        String price = intent.getStringExtra("price");

        TextView nameViewDetail = findViewById(R.id.name_detail);
        nameViewDetail.setText(name);

        ImageView imageViewDetail = findViewById(R.id.image_detail);
        imageViewDetail.setImageResource(image);

        TextView typeViewDetail = findViewById(R.id.type_detail);
        typeViewDetail.setText(type);

        TextView priceViewDetail = findViewById(R.id.price_detail);
        priceViewDetail.setText(price);
    }
}
