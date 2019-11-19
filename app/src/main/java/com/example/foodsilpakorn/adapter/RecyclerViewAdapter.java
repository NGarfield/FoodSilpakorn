package com.example.foodsilpakorn.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodsilpakorn.R;
import com.example.foodsilpakorn.RestaurantsDetail;
import com.example.foodsilpakorn.model.Restaurants;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private int mResource;
    private List<Restaurants> mRestaurantsList;

    public RecyclerViewAdapter(Context mContext, int mResource, List<Restaurants> mRestaurantsList) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mRestaurantsList = mRestaurantsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Restaurants restaurants= mRestaurantsList.get(position);

        holder.restaurants = restaurants;
        holder.nameTextView.setText(restaurants.name);
        holder.typeTextView.setText(restaurants.type);
        holder.restaurantsImageView.setImageResource(R.drawable.restauranticon);
    }

    @Override
    public int getItemCount() {
        return mRestaurantsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView restaurantsImageView;
        private TextView nameTextView;
        private TextView typeTextView;

        private Restaurants restaurants;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.restaurantsImageView = itemView.findViewById(R.id.image_restaurant);
            this.nameTextView = itemView.findViewById(R.id.text_name_view);
            this.typeTextView = itemView.findViewById(R.id.text_type_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, RestaurantsDetail.class);
                    intent.putExtra("name", restaurants.name);
                    intent.putExtra("image", R.drawable.restauranticon);
                    intent.putExtra("type",restaurants.type);
                    intent.putExtra("price",restaurants.price);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
