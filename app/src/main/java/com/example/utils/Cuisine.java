
package com.example.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cuisine implements Serializable {

    @SerializedName("cuisine_id")
    @Expose
    private Integer cuisineId;
    @SerializedName("cuisine_name")
    @Expose
    private String cuisineName;
    @SerializedName("restaurant_id")
    @Expose
    private String restaurantId;
    @SerializedName("added_at")
    @Expose
    private String addedAt;
    @SerializedName("is_visible")
    @Expose
    private Boolean isVisible;
    @SerializedName("is_deleted")
    @Expose
    private Boolean isDeleted;

    public Integer getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(Integer cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(String addedAt) {
        this.addedAt = addedAt;
    }

    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}
