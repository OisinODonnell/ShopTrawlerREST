package org.fyp.model;

import javax.persistence.*;

/**
 * Created by Oisin on 7/18/2017.
 */
@Entity
@Table(name = "userpoints", schema = "shoptrawler", catalog = "")
@IdClass(UserpointPK.class)
public class Userpoint {
    private int userId;
    private int retailerId;
    private Integer points;

    @Id
    @Column(name = "userID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "retailerID")
    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    @Basic
    @Column(name = "points")
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

        Userpoint userpoint = (Userpoint) o;

        if (userId != userpoint.userId) return false;
        if (retailerId != userpoint.retailerId) return false;
        if (points != null ? !points.equals(userpoint.points) : userpoint.points != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + retailerId;
        result = 31 * result + (points != null ? points.hashCode() : 0);
        return result;
    }
}
