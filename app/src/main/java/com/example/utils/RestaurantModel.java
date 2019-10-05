
package com.example.utils;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestaurantModel implements Serializable {

    @SerializedName("restaurant_id")
    @Expose
    private String restaurantId;
    @SerializedName("restaurant_name")
    @Expose
    private String restaurantName;
    @SerializedName("avg_cost_for_two")
    @Expose
    private Integer avgCostForTwo;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("table_count")
    @Expose
    private Integer tableCount;
    @SerializedName("does_bookings")
    @Expose
    private Boolean doesBookings;
    @SerializedName("location_id")
    @Expose
    private String locationId;
    @SerializedName("type_id")
    @Expose
    private String typeId;
    @SerializedName("restaurant_uuid")
    @Expose
    private String restaurantUuid;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("restaurant_mode")
    @Expose
    private String restaurantMode;
    @SerializedName("opens_at")
    @Expose
    private String opensAt;
    @SerializedName("closes_at")
    @Expose
    private String closesAt;
    @SerializedName("qr_active")
    @Expose
    private Boolean qrActive;
    @SerializedName("address_complete")
    @Expose
    private String addressComplete;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("restaurant_type")
    @Expose
    private RestaurantType restaurantType;
    @SerializedName("cuisines")
    @Expose
    private List<Cuisine> cuisines = null;
    @SerializedName("rating")
    @Expose
    private Rating rating;

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Integer getAvgCostForTwo() {
        return avgCostForTwo;
    }

    public void setAvgCostForTwo(Integer avgCostForTwo) {
        this.avgCostForTwo = avgCostForTwo;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getTableCount() {
        return tableCount;
    }

    public void setTableCount(Integer tableCount) {
        this.tableCount = tableCount;
    }

    public Boolean getDoesBookings() {
        return doesBookings;
    }

    public void setDoesBookings(Boolean doesBookings) {
        this.doesBookings = doesBookings;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getRestaurantUuid() {
        return restaurantUuid;
    }

    public void setRestaurantUuid(String restaurantUuid) {
        this.restaurantUuid = restaurantUuid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRestaurantMode() {
        return restaurantMode;
    }

    public void setRestaurantMode(String restaurantMode) {
        this.restaurantMode = restaurantMode;
    }

    public String getOpensAt() {
        return opensAt;
    }

    public void setOpensAt(String opensAt) {
        this.opensAt = opensAt;
    }

    public String getClosesAt() {
        return closesAt;
    }

    public void setClosesAt(String closesAt) {
        this.closesAt = closesAt;
    }

    public Boolean getQrActive() {
        return qrActive;
    }

    public void setQrActive(Boolean qrActive) {
        this.qrActive = qrActive;
    }

    public String getAddressComplete() {
        return addressComplete;
    }

    public void setAddressComplete(String addressComplete) {
        this.addressComplete = addressComplete;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public RestaurantType getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(RestaurantType restaurantType) {
        this.restaurantType = restaurantType;
    }

    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

}
