package com.example.foodsilpakorn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.foodsilpakorn.adapter.RecyclerViewAdapter;
import com.example.foodsilpakorn.model.Restaurants;
import com.example.foodsilpakorn.room_db.RestautantsRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAdd = findViewById(R.id.add_restaurants_button);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                intent.putExtra("type", 0);
                startActivity(intent);
            }
        });
    }

        @Override
        protected void onResume () {
            super.onResume();
            reloadData();
        }

        private void reloadData(){
            RestautantsRepository repo = new RestautantsRepository(MainActivity.this);

            repo.getRestautants(new RestautantsRepository.Callback() {
                @Override
                public void onGetLedger(List<Restaurants> itemList) {

                    RecyclerView recyclerView = findViewById(R.id.recyclerView);
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(
                            MainActivity.this,
                            R.layout.item_restaurants,
                            itemList
                    );
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setAdapter(adapter);
                }
            });
        }
}