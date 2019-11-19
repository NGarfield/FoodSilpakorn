package com.example.foodsilpakorn.room_db;
        import androidx.room.Dao;
        import androidx.room.Insert;
        import androidx.room.Query;

        import com.example.foodsilpakorn.model.Restaurants;

        import java.util.List;


@Dao
public interface RestaurantsDao {

    @Query("SELECT * FROM restaurants")
    List<Restaurants> getAll();

    @Insert
    void insertRestaurants(Restaurants restaurants);
}
