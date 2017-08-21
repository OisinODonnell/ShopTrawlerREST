package org.fyp.model;

import java.util.ArrayList;
import java.util.List;

public class AgeCount {

    private int retailerid;
    private String storeName;
    private List<Integer> counts;
    private String[]  labels;
    private List<Integer> maleCounts;
    private List<Integer> femaleCounts;


    public AgeCount() {
        this.retailerid = 0;
        this.storeName = "";
        this.counts = new ArrayList<>();
        this.labels = new String[8];
        this.maleCounts = new ArrayList<>();
        this.femaleCounts = new ArrayList<>();
    }

    public AgeCount(int retailerid, String storeName, List<Integer> counts, String[] labels, List<Integer> maleCounts, List<Integer> femaleCounts) {
        this.retailerid = retailerid;
        this.storeName = storeName;
        this.counts = counts;
        this.labels = labels;
        this.maleCounts = maleCounts;
        this.femaleCounts = femaleCounts;
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

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
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
