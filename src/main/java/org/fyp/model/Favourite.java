package org.fyp.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Oisin on 7/18/2017.
 */
@Entity
@Table(name = "favourites", schema = "shoptrawler", catalog = "")
@IdClass(FavouritePK.class)
public class Favourite {
    private int retailerId;
    private int userId;

    public Favourite() {

    }

    public Favourite(List<String> attributes) {


    }

    @Id
    @Column(name = "retailerID")
    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    @Id
    @Column(name = "userID")
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

        Favourite favourite = (Favourite) o;

        if (retailerId != favourite.retailerId) return false;
        if (userId != favourite.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = retailerId;
        result = 31 * result + userId;
        return result;
    }
}
