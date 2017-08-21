package org.fyp.model;

public class RatingCount {

    private Integer retailerid;
    private String storeName;
    private Float rating;

    public RatingCount() {
        retailerid = 0;
        storeName = "";
        rating = null;
    }

    public RatingCount(Integer retailerid, String storeName, Float rating) {
        this.retailerid = retailerid;
        this.storeName = storeName;
        this.rating = rating;
    }

    public Integer getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(Integer retailerid) {
        this.retailerid = retailerid;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
