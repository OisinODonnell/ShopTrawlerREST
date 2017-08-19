package org.fyp.model;

import java.util.ArrayList;
import java.util.List;

public class VisitChart {

    private List<Integer> counts;
    private List<String>  xLabels;
    private String        storeName;
    private int           retailerid;


    public VisitChart( ) {
        this.storeName = "";
        this.xLabels    = new ArrayList<>();
        this.counts     = new ArrayList<>();
        this.retailerid = 0;
    }

    public VisitChart( List<Integer> counts, List<String> xLabels, String storeName, int retailerid ) {
        this.counts     = counts;
        this.xLabels    = xLabels;
        this.storeName  = storeName;
        this.retailerid = retailerid;
    }


    public void add(int count, String xLabel, String retailer) {
        addCount(count);
        addXLabel(xLabel);
        setStoreName( retailer);
    }
    public void add(int count, String xLabel) {
        addCount(count);
        addXLabel(xLabel);
    }


    public List<Integer> getCounts( ) {
        return counts;
    }

    public void setCounts( List<Integer> counts ) {
        this.counts = counts;
    }

    public List<String> getXLabels( ) {
        return xLabels;
    }

    public void setXLabels( List<String> xLabels ) {
        this.xLabels = xLabels;
    }

    public String getStoreName( ) {
        return storeName;
    }

    public void setStoreName( String storeName ) {
        this.storeName = storeName;
    }

    public void addCount(int count) {
        this.counts.add(count);
    }
    public void addXLabel(String xLabel) {
        this.xLabels.add(xLabel);
    }

    public void setxLabels( List<String> xLabels ) {
        this.xLabels = xLabels;
    }

    public int getRetailerid( ) {
        return retailerid;
    }

    public void setRetailerid( int retailerid ) {
        this.retailerid = retailerid;
    }
}


