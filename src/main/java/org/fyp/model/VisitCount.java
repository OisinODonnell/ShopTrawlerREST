package org.fyp.model;

import java.sql.Timestamp;
import java.util.List;

public class VisitCount {

    private Timestamp startTime; // startime in millisends
    private int       retailerid;
    private String    storeName;
    private int       duration ; // 1 = day, 2 = week, 3 = month
    private long      count ; // number of visits
    private int       period;
    private List<Integer> counts;
    private List<String>  xAxesLabels;
    private List<String> retailers;



    public VisitCount() {
    }

    public VisitCount( Timestamp startDate, int retailerid, String storeName, int duration, int period, long count ) {
        this.startTime  = startDate;
        this.retailerid = retailerid;
        this.storeName  = storeName;
        this.duration   = duration;
        this.period     = period;
        this.count      = count;
    }

    public Timestamp getStartTime( ) {
        return startTime;
    }

    public void setStartTime( Timestamp startTime ) {
        this.startTime = startTime;
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

    public int getPeriod( ) {  return period;    }

    public void setPeriod( int period ) {  this.period = period;    }
}
