package com.example.foodsilpakorn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.foodsilpakorn.model.Restaurants;
import com.example.foodsilpakorn.room_db.RestautantsRepository;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Intent intent = getIntent();

        Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameT = findViewById(R.id.insert_name);
                String name = nameT.getText().toString();

                EditText typrT = findViewById(R.id.insert_type);
                String type = typrT.getText().toString();

                EditText priceT = findViewById(R.id.insert_price);
                String price = priceT.getText().toString();

                Restaurants restaurants = new Restaurants(0,name,price,type);

                RestautantsRepository repo = new RestautantsRepository(InsertActivity.this);
                repo.insertRestautants(restaurants, new RestautantsRepository.InsertCallback() {
                    @Override
                    public void onInsertSuccess() {
                        finish();
                    }
                });
            }
        });

    }
}
