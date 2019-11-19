package com.example.foodsilpakorn.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "restaurants")
public class Restaurants {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "price")
    public String price;

    @ColumnInfo(name = "type")
    public String type;

    public Restaurants(int id, String name, String price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }


}
