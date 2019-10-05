
package com.example.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("location_id")
    @Expose
    private Integer locationId;
    @SerializedName("location_address")
    @Expose
    private String locationAddress;
    @SerializedName("location_zip_code")
    @Expose
    private Integer locationZipCode;
    @SerializedName("location_lat")
    @Expose
    private Double locationLat;
    @SerializedName("location_long")
    @Expose
    private Double locationLong;
    @SerializedName("location_locality")
    @Expose
    private String locationLocality;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("country_id")
    @Expose
    private String countryId;
    @SerializedName("state_id")
    @Expose
    private String stateId;

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public Integer getLocationZipCode() {
        return locationZipCode;
    }

    public void setLocationZipCode(Integer locationZipCode) {
        this.locationZipCode = locationZipCode;
    }

    public Double getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(Double locationLat) {
        this.locationLat = locationLat;
    }

    public Double getLocationLong() {
        return locationLong;
    }

    public void setLocationLong(Double locationLong) {
        this.locationLong = locationLong;
    }

    public String getLocationLocality() {
        return locationLocality;
    }

    public void setLocationLocality(String locationLocality) {
        this.locationLocality = locationLocality;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

}
