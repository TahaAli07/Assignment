
package com.example.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("restaurant_avg_rating")
    @Expose
    private String restaurantAvgRating;

    public String getRestaurantAvgRating() {
        return restaurantAvgRating;
    }

    public void setRestaurantAvgRating(String restaurantAvgRating) {
        this.restaurantAvgRating = restaurantAvgRating;
    }

}
