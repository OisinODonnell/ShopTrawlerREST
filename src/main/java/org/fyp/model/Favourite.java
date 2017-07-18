package org.fyp.model;

import javax.persistence.*;

@Entity
@Table(name = "favourites", schema = "shoptrawler", catalog = "")
@IdClass(FavouritePK.class)
public class Favourite {
    private int userid;
    private int retailerid;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Favourite favourite = (Favourite) o;

        if (userid != favourite.userid) return false;
        if (retailerid != favourite.retailerid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + retailerid;
        return result;
    }
}
