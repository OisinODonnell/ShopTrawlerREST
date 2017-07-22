package org.fyp.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

@Entity
@Table(name = "visits", schema = "shoptrawler")
public class Visit extends BaseEntity {
    private int visitid;
    private Integer duration;
    private Timestamp entryTime;
    private Timestamp exitTime;
    private Integer userCreditedForVisit;
    private int userid;
    private int zoneid;
    private User usersByUserid;
    private Zone zonesByZoneid;

    public Visit() {
    }

    public Visit(List<String> attributes) {
        this.zoneid = toInteger(attributes.get(0));
        this.visitid = toInteger(attributes.get(1));
        this.userid = toInteger(attributes.get(2));
        this.duration = toInteger(attributes.get(3));
        this.entryTime = toTimestamp(attributes.get(4));
        this.exitTime = toTimestamp(attributes.get(5));
    }
    @Id
    @Column(name = "visitid")
    public int getVisitid() {
        return visitid;
    }

    public void setVisitid(int visitid) {
        this.visitid = visitid;
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
    @Column(name = "entry_time")
    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    @Basic
    @Column(name = "exit_time")
    public Timestamp getExitTime() {
        return exitTime;
    }

    public void setExitTime(Timestamp exitTime) {
        this.exitTime = exitTime;
    }

    @Basic
    @Column(name = "user_credited_for_visit")
    public Integer getUserCreditedForVisit() {
        return userCreditedForVisit;
    }

    public void setUserCreditedForVisit(Integer userCreditedForVisit) {
        this.userCreditedForVisit = userCreditedForVisit;
    }

    @Basic
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "zoneid")
    public int getZoneid() {
        return zoneid;
    }

    public void setZoneid(int zoneid) {
        this.zoneid = zoneid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visit visit = (Visit) o;

        if (visitid != visit.visitid) return false;
        if (userid != visit.userid) return false;
        if (zoneid != visit.zoneid) return false;
        if (duration != null ? !duration.equals(visit.duration) : visit.duration != null) return false;
        if (entryTime != null ? !entryTime.equals(visit.entryTime) : visit.entryTime != null) return false;
        if (exitTime != null ? !exitTime.equals(visit.exitTime) : visit.exitTime != null) return false;
        if (userCreditedForVisit != null ? !userCreditedForVisit.equals(visit.userCreditedForVisit) : visit.userCreditedForVisit != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = visitid;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (entryTime != null ? entryTime.hashCode() : 0);
        result = 31 * result + (exitTime != null ? exitTime.hashCode() : 0);
        result = 31 * result + (userCreditedForVisit != null ? userCreditedForVisit.hashCode() : 0);
        result = 31 * result + userid;
        result = 31 * result + zoneid;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false,insertable = false, updatable = false)
    public User getUsersByUserid() {
        return usersByUserid;
    }

    public void setUsersByUserid(User usersByUserid) {
        this.usersByUserid = usersByUserid;
    }

    @ManyToOne
    @JoinColumn(name = "zoneid", referencedColumnName = "zoneid", nullable = false,insertable = false, updatable = false)
    public Zone getZonesByZoneid() {
        return zonesByZoneid;
    }

    public void setZonesByZoneid(Zone zonesByZoneid) {
        this.zonesByZoneid = zonesByZoneid;
    }
}
