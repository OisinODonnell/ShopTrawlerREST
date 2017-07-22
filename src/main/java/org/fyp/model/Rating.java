package org.fyp.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "ratings", schema = "shoptrawler")
@IdClass(RatingPK.class)
public class Rating extends BaseEntity {
    private int userid;
    private Integer retailerid;
    private Timestamp date;
    private Integer rating;
    private String review;
    private User usersByUserid;
    private Retailer retailersByRetailerid;

    public Rating() {
    }

    public Rating(List<String> attributes)  {
        this.userid     = toInteger(attributes.get(0));
        this.retailerid = toInteger(attributes.get(1));
        this.date       = toTimestamp(attributes.get(2));
        this.rating     = toInteger(attributes.get(3));
        this.review     = attributes.get(4);

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
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "review", length = 255)
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating1 = (Rating) o;

        if (userid != rating1.userid) return false;
        if (retailerid != rating1.retailerid) return false;
        if (date != null ? !date.equals(rating1.date) : rating1.date != null) return false;
        if (rating != null ? !rating.equals(rating1.rating) : rating1.rating != null) return false;
        if (review != null ? !review.equals(rating1.review) : rating1.review != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + retailerid;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (review != null ? review.hashCode() : 0);
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
