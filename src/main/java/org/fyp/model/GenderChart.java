package org.fyp.model;

public class GenderChart {

    private int retailerid;
    private String storeName;
    private int maleCount;
    private int femaleCount;
    private String[] xLabels;

    public GenderChart() {
        retailerid  = 0;
        storeName = "";
        maleCount = 0;
        femaleCount = 0;
        xLabels = new String[2];
    }

    public GenderChart( int retailerid, String storeName, int startYear, int endYear, int maleCount, int femaleCount) {
        this.retailerid = retailerid;
        this.storeName = storeName;
        this.maleCount = maleCount;
        this.femaleCount = femaleCount;
        this.xLabels = new String[]{"Male", "Female"};
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

    public String[] getxLabels( ) {
        return xLabels;
    }

    public void setxLabels( String[] xLabels ) {
        this.xLabels = xLabels;
    }
}
