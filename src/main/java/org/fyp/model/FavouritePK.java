package org.fyp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Oisin on 7/18/2017.
 */
public class FavouritePK implements Serializable {
    private int retailerId;
    private int userId;

    @Column(name = "retailerID")
    @Id
    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    @Column(name = "userID")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavouritePK that = (FavouritePK) o;

        if (retailerId != that.retailerId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = retailerId;
        result = 31 * result + userId;
        return result;
    }
}
