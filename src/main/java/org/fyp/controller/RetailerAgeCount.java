package org.fyp.controller;

import org.fyp.model.AgeCount;

import java.util.ArrayList;
import java.util.Collection;

public class RetailerAgeCount {
    int retailerid;
    String storeName;
    Collection<AgeCount> ageCounts;

    public RetailerAgeCount() {
        this.retailerid = 0;
        this.storeName = "";
        this.ageCounts = new ArrayList<>();
    }

    public RetailerAgeCount(int retailerid, String storeName, Collection<AgeCount> ageCounts) {
        this.retailerid = retailerid;
        this.storeName = storeName;
        this.ageCounts = ageCounts;
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

    public Collection<AgeCount> getAgeCounts() {
        return ageCounts;
    }

    public void setAgeCounts(Collection<AgeCount> ageCounts) {
        this.ageCounts = ageCounts;
    }
}
