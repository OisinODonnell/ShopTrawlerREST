package org.fyp.model;

import javax.persistence.*;

@Entity
@Table(name = "userpoints", schema = "shoptrawler", catalog = "")
@IdClass(UserPointPK.class)
public class UserPoint {
    private int userid;
    private int retailerid;
    private Integer points;

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
    public int getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(int retailerid) {
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
}
