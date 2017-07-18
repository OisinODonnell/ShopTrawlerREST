package org.fyp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Oisin on 7/18/2017.
 */
public class UserpointPK implements Serializable {
    private int userId;
    private int retailerId;

    @Column(name = "userID")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "retailerID")
    @Id
    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserpointPK that = (UserpointPK) o;

        if (userId != that.userId) return false;
        if (retailerId != that.retailerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + retailerId;
        return result;
    }
}
