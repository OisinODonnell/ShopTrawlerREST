package org.fyp.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Oisin on 7/18/2017.
 */
@Entity
@Table(name = "ratings", schema = "shoptrawler", catalog = "")
@IdClass(RatingPK.class)
public class Rating {
    private int userId;
    private int retailerId;
    private String rating;
    private String review;
    private Timestamp date;

    public Rating() {

    }

    public Rating(List<String> attributes) {


    }

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
    @Column(name = "rating")
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "review")
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating1 = (Rating) o;

        if (userId != rating1.userId) return false;
        if (retailerId != rating1.retailerId) return false;
        if (rating != null ? !rating.equals(rating1.rating) : rating1.rating != null) return false;
        if (review != null ? !review.equals(rating1.review) : rating1.review != null) return false;
        if (date != null ? !date.equals(rating1.date) : rating1.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + retailerId;
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (review != null ? review.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
