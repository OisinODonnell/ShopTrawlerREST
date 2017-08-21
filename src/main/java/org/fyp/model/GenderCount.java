package org.fyp.model;

public class GenderCount {

    private int retailerid;
    private String storeName;
    private int maleCount;
    private int femaleCount;

    public GenderCount() {
        retailerid  = 0;
        storeName = "";
        maleCount = 0;
        femaleCount = 0;
    }

    public GenderCount(int retailerid, String storeName, int startYear, int endYear, int maleCount, int femaleCount) {
        this.retailerid = retailerid;
        this.storeName = storeName;
        this.maleCount = maleCount;
        this.femaleCount = femaleCount;
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

    public int getMaleCount() {
        return maleCount;
    }

    public void setMaleCount(int maleCount) {
        this.maleCount = maleCount;
    }

    public int getFemaleCount() {
        return femaleCount;
    }

    public void setFemaleCount(int femaleCount) {
        this.femaleCount = femaleCount;
    }

}
