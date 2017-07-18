package org.fyp.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Oisin on 7/18/2017.
 */
@Entity
@Table(name = "visits", schema = "shoptrawler", catalog = "")
@IdClass(VisitPK.class)
public class Visit {
    private int visitId;
    private int userId;
    private int zoneId;
    private Integer duration;
    private Timestamp entryTime;
    private Timestamp exitTime;

    public Visit() {

    }

    public Visit(List<String> attributes) {


    }

    @Id
    @Column(name = "visitID")
    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    @Id
    @Column(name = "userID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "zoneID")
    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    @Basic
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "entryTime")
    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    @Basic
    @Column(name = "exitTime")
    public Timestamp getExitTime() {
        return exitTime;
    }

    public void setExitTime(Timestamp exitTime) {
        this.exitTime = exitTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visit visit = (Visit) o;

        if (visitId != visit.visitId) return false;
        if (userId != visit.userId) return false;
        if (zoneId != visit.zoneId) return false;
        if (duration != null ? !duration.equals(visit.duration) : visit.duration != null) return false;
        if (entryTime != null ? !entryTime.equals(visit.entryTime) : visit.entryTime != null) return false;
        if (exitTime != null ? !exitTime.equals(visit.exitTime) : visit.exitTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = visitId;
        result = 31 * result + userId;
        result = 31 * result + zoneId;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (entryTime != null ? entryTime.hashCode() : 0);
        result = 31 * result + (exitTime != null ? exitTime.hashCode() : 0);
        return result;
    }
}
