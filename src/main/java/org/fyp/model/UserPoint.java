package org.fyp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userpoints", schema = "shoptrawler")
@IdClass(UserPointPK.class)
public class UserPoint extends BaseEntity {

    private int userid;
    private Integer retailerid;
    private Integer points;
    @JsonBackReference
    private User usersByUserid;
    @JsonBackReference
    private Retailer retailersByRetailerid;

    public UserPoint() {
    }

    public UserPoint(List<String> attributes) {
        this.userid         = toInteger( attributes.get(0));
        this.retailerid     = toInteger( attributes.get(1));
        this.points         = toInteger( attributes.get(2));
    }
    @Id
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Id
    @Column(name = "retailerid", nullable = false)
    public Integer getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(Integer retailerid) {
        this.retailerid = retailerid;
    }

    @Basic
    @Column(name = "points", nullable = true)
    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPoint userPoint = (UserPoint) o;

        if (userid != userPoint.userid) return false;
        if (retailerid != userPoint.retailerid) return false;
        if (points != null ? !points.equals(userPoint.points) : userPoint.points != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + retailerid;
        result = 31 * result + (points != null ? points.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false,insertable = false, updatable = false)
    public User getUsersByUserid() {
        return usersByUserid;
    }

    public void setUsersByUserid(User usersByUserid) { this.usersByUserid = usersByUserid; }

    @ManyToOne
    @JoinColumn(name = "retailerid", referencedColumnName = "retailerid", nullable = false,insertable = false, updatable = false)
    public Retailer getRetailersByRetailerid() {
        return retailersByRetailerid;
    }

    public void setRetailersByRetailerid(Retailer retailersByRetailerid) {
        this.retailersByRetailerid = retailersByRetailerid;
    }
}
