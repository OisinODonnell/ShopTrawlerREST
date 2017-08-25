package org.fyp.controller;

import org.fyp.model.AgeChart;

import java.util.ArrayList;
import java.util.Collection;

public class RetailerAgeCount {
    int                  retailerid;
    String               storeName;
    Collection<AgeChart> ageCharts;

    public RetailerAgeCount() {
        this.retailerid = 0;
        this.storeName = "";
        this.ageCharts = new ArrayList<>();
    }

    public RetailerAgeCount(int retailerid, String storeName, Collection<AgeChart> ageCharts ) {
        this.retailerid = retailerid;
        this.storeName = storeName;
        this.ageCharts = ageCharts;
    }

    public int getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(int retailerid) {
        this.retailerid = retailerid;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Collection<AgeChart> getAgeCharts() {
        return ageCharts;
    }

    public void setAgeCharts( Collection<AgeChart> ageCharts ) {
        this.ageCharts = ageCharts;
    }
}
