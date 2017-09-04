package org.fyp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "visits", schema = "shoptrawler")
public class Visit extends BaseEntity {
    private int visitid;
    private Integer duration;
    private Timestamp entryTime;
    private Timestamp exitTime;
    private Integer userid;
    private Integer zoneid;
//    @JsonBackReference
    @JsonIgnore
    private User usersByUserid;
//    @JsonBackReference
    @JsonIgnore
    private Zone zonesByZoneid;

    public Visit() {
    }

    public Visit(List<String> attributes) {
        this.visitid = toInteger(attributes.get(0));
        this.zoneid = toInteger(attributes.get(1));
        this.userid = toInteger(attributes.get(2));
        this.duration = toInteger(attributes.get(3));
        this.entryTime = toTimestamp(attributes.get(4));
        this.exitTime = toTimestamp(attributes.get(5));
    }

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "visitid", nullable = false)
    public int getVisitid() {
        return visitid;
    }

    public void setVisitid(int visitid) {
        this.visitid = visitid;
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

    @Basic
    @Column(name = "userid", nullable = true)
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "zoneid", nullable = true)
    public Integer getZoneid() {
        return zoneid;
    }

    public void setZoneid(Integer zoneid) {
        this.zoneid = zoneid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visit visit = (Visit) o;

        if (visitid != visit.visitid) return false;
        if (duration != null ? !duration.equals(visit.duration) : visit.duration != null) return false;
        if (entryTime != null ? !entryTime.equals(visit.entryTime) : visit.entryTime != null) return false;
        if (exitTime != null ? !exitTime.equals(visit.exitTime) : visit.exitTime != null) return false;
        if (userid != null ? !userid.equals(visit.userid) : visit.userid != null) return false;
        if (zoneid != null ? !zoneid.equals(visit.zoneid) : visit.zoneid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = visitid;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (entryTime != null ? entryTime.hashCode() : 0);
        result = 31 * result + (exitTime != null ? exitTime.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (zoneid != null ? zoneid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid",insertable = false, updatable = false)
    public User getUsersByUserid() {
        return usersByUserid;
    }

    public void setUsersByUserid(User usersByUserid) {
        this.usersByUserid = usersByUserid;
    }

    @ManyToOne
    @JoinColumn(name = "zoneid", referencedColumnName = "zoneid",insertable = false, updatable = false)
    public Zone getZonesByZoneid() {
        return zonesByZoneid;
    }

    public void setZonesByZoneid(Zone zonesByZoneid) {
        this.zonesByZoneid = zonesByZoneid;
    }
}
