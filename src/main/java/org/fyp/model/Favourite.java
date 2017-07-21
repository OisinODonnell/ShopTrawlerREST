package org.fyp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "favourites", schema = "shoptrawler")
@IdClass(FavouritePK.class)
public class Favourite extends BaseEntity {
    private int userid;
    private int retailerid;
    private User usersByUserid;
    private Retailer retailersByRetailerid;

    public Favourite(List<String> attributes) {
        this.userid     = toInteger(attributes.get(0));
        this.retailerid = toInteger(attributes.get(1));
    }

    public Favourite() {
    }
    @Id
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Id
    @Column(name = "retailerid")
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

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false,insertable = false, updatable = false)
    public User getUsersByUserid() {
        return usersByUserid;
    }

    public void setUsersByUserid(User usersByUserid) {
        this.usersByUserid = usersByUserid;
    }

    @ManyToOne
    @JoinColumn(name = "retailerid", referencedColumnName = "retailerid", nullable = false,insertable = false, updatable = false)
    public Retailer getRetailersByRetailerid() {
        return retailersByRetailerid;
    }

    public void setRetailersByRetailerid(Retailer retailersByRetailerid) {
        this.retailersByRetailerid = retailersByRetailerid;
    }
}
