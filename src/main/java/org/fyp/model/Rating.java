package org.fyp.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ratings", schema = "shoptrawler", catalog = "")
@IdClass(RatingPK.class)
public class Rating {
    private int userid;
    private int retailerid;
    private Timestamp date;
    private String rating;
    private String review;

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
    @Column(name = "date", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "rating", nullable = true, length = 255)
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "review", nullable = true, length = 255)
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
}
