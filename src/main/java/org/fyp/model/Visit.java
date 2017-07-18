package org.fyp.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "visits", schema = "shoptrawler", catalog = "")
@IdClass(VisitPK.class)
public class Visit {
    private int zoneid;
    private int visitid;
    private int userid;
    private Integer duration;
    private Timestamp entryTime;
    private Timestamp exitTime;

    @Id
    @Column(name = "zoneid", nullable = false)
    public int getZoneid() {
        return zoneid;
    }

    public void setZoneid(int zoneid) {
        this.zoneid = zoneid;
    }

    @Id
    @Column(name = "visitid", nullable = false)
    public int getVisitid() {
        return visitid;
    }

    public void setVisitid(int visitid) {
        this.visitid = visitid;
    }

    @Id
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "duration", nullable = true)
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "entry_time", nullable = true)
    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    @Basic
    @Column(name = "exit_time", nullable = true)
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

        if (zoneid != visit.zoneid) return false;
        if (visitid != visit.visitid) return false;
        if (userid != visit.userid) return false;
        if (duration != null ? !duration.equals(visit.duration) : visit.duration != null) return false;
        if (entryTime != null ? !entryTime.equals(visit.entryTime) : visit.entryTime != null) return false;
        if (exitTime != null ? !exitTime.equals(visit.exitTime) : visit.exitTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zoneid;
        result = 31 * result + visitid;
        result = 31 * result + userid;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (entryTime != null ? entryTime.hashCode() : 0);
        result = 31 * result + (exitTime != null ? exitTime.hashCode() : 0);
        return result;
    }
}
