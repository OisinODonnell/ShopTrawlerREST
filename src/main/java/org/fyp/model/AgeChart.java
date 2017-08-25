package org.fyp.model;

import java.util.ArrayList;
import java.util.List;

public class AgeChart {

    private int           retailerid;
    private String        storeName;
    private List<Integer> counts;
    private String[]      xLabels;
    private List<Integer> maleCounts;
    private List<Integer> femaleCounts;


    public AgeChart() {
        this.retailerid = 0;
        this.storeName = "";
        this.counts = new ArrayList<>();
        this.xLabels = new String[8];
        this.maleCounts = new ArrayList<>();
        this.femaleCounts = new ArrayList<>();
        this.xLabels = new String[]{ "0-20", "21-30", "31-40", "41-50", "51-60", "61-70", "71-80", ">80" };
    }

    public AgeChart( int retailerid, String storeName, List<Integer> counts, String[] xLabels, List<Integer> maleCounts, List<Integer> femaleCounts) {
        this.retailerid = retailerid;
        this.storeName = storeName;
        this.counts = counts;
        this.xLabels = xLabels;
        this.maleCounts = maleCounts;
        this.femaleCounts = femaleCounts;
        this.xLabels = new String[]{ "0-20", "21-30", "31-40", "41-50", "51-60", "61-70", "71-80", ">80" };
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

    public List<Integer> getCounts() {
        return counts;
    }

    public void setCounts(List<Integer> counts) {
        this.counts = counts;
    }

    public String[] getxLabels() {
        return xLabels;
    }

    public void setxLabels( String[] xLabels ) {
        this.xLabels = xLabels;
    }

    public List<Integer> getMaleCounts() {
        return maleCounts;
    }

    public void setMaleCounts(List<Integer> maleCounts) {
        this.maleCounts = maleCounts;
    }

    public List<Integer> getFemaleCounts() {
        return femaleCounts;
    }

    public void setFemaleCounts(List<Integer> femaleCounts) {
        this.femaleCounts = femaleCounts;
    }
    public void incFemale(int index) {
        int count = femaleCounts.get(index);
        femaleCounts.set(index, count++);
    }
    public void incMale(int index) {
        int count = maleCounts.get(index);
        maleCounts.set(index, count++);
    }

    public void incCounts(int index, int count) {
        counts.set(index, count);
    }
}
