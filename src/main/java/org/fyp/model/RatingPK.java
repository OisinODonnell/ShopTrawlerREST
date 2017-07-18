package org.fyp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RatingPK implements Serializable {
    private int userid;
    private int retailerid;

    @Column(name = "userid", nullable = false)
    @Id
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Column(name = "retailerid", nullable = false)
    @Id
    public int getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(int retailerid) {
        this.retailerid = retailerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RatingPK ratingPK = (RatingPK) o;

        if (userid != ratingPK.userid) return false;
        if (retailerid != ratingPK.retailerid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + retailerid;
        return result;
    }
}
