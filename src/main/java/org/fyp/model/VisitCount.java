package org.fyp.model;

import java.sql.Timestamp;

public class VisitCount {

    private Timestamp startDate; // startime in millisends
    private int       retailerid;
    private String    storeName;
    private int       duration ; // 1 = day, 2 = week, 3 = month
    private long       count ; // number ov visits

    public VisitCount() {

    }

    public VisitCount( Timestamp startDate, int retailerid, String storeName, int duration, long count ) {
        this.startDate = startDate;
        this.retailerid = retailerid;
        this.storeName = storeName;
        this.duration = duration;
        this.count = count;
    }

    public Timestamp getStartTime( ) {
        return startDate;
    }

    public void setStartTime( Timestamp startTime ) {
        this.startDate = startTime;
    }

    public int getRetailerid( ) {
        return retailerid;
    }

    public void setRetailerid( int retailerid ) {
        this.retailerid = retailerid;
    }

    public String getStoreName( ) {
        return storeName;
    }

    public void setStoreName( String storeName ) {
        this.storeName = storeName;
    }

    public int getDuration( ) {
        return duration;
    }

    public void setDuration( int duration ) {
        this.duration = duration;
    }

    public long getCount( ) {
        return count;
    }

    public void setCount( long count ) {
        this.count = count;
    }
}
