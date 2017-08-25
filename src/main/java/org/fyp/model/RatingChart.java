package org.fyp.model;

public class RatingChart {

    private Integer retailerid;
    private String storeName;
    private Float rating;
    private String[] xLabels;

    public RatingChart() {
        retailerid = 0;
        storeName = "";
        rating = null;
        this.xLabels = new String[1];
    }

    public RatingChart( Integer retailerid, String storeName, Float rating) {
        this.retailerid = retailerid;
        this.storeName = storeName;
        this.rating = rating;
    }

    public String[] getxLabels( ) {
        return xLabels;
    }

    public void setxLabels( String[] xLabels ) {
        this.xLabels = xLabels;
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
