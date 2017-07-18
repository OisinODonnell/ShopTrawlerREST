package org.fyp.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Oisin on 7/18/2017.
 */
@Entity
@Table(name = "loyaltyrewards", schema = "shoptrawler", catalog = "")
@IdClass(LoyaltyrewardPK.class)
public class Loyaltyreward {
    private int loyaltyRewardId;
    private int retailerId;
    private Integer visitTime;
    private Integer pointsPerVisit;
    private Integer rewardTitle;
    private String rewardImage;
    private Timestamp startDate;
    private Timestamp endDate;

    @Id
    @Column(name = "loyaltyRewardID")
    public int getLoyaltyRewardId() {
        return loyaltyRewardId;
    }

    public void setLoyaltyRewardId(int loyaltyRewardId) {
        this.loyaltyRewardId = loyaltyRewardId;
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
    @Column(name = "visitTime")
    public Integer getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Integer visitTime) {
        this.visitTime = visitTime;
    }

    @Basic
    @Column(name = "pointsPerVisit")
    public Integer getPointsPerVisit() {
        return pointsPerVisit;
    }

    public void setPointsPerVisit(Integer pointsPerVisit) {
        this.pointsPerVisit = pointsPerVisit;
    }

    @Basic
    @Column(name = "rewardTitle")
    public Integer getRewardTitle() {
        return rewardTitle;
    }

    public void setRewardTitle(Integer rewardTitle) {
        this.rewardTitle = rewardTitle;
    }

    @Basic
    @Column(name = "rewardImage")
    public String getRewardImage() {
        return rewardImage;
    }

    public void setRewardImage(String rewardImage) {
        this.rewardImage = rewardImage;
    }

    @Basic
    @Column(name = "startDate")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "endDate")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loyaltyreward that = (Loyaltyreward) o;

        if (loyaltyRewardId != that.loyaltyRewardId) return false;
        if (retailerId != that.retailerId) return false;
        if (visitTime != null ? !visitTime.equals(that.visitTime) : that.visitTime != null) return false;
        if (pointsPerVisit != null ? !pointsPerVisit.equals(that.pointsPerVisit) : that.pointsPerVisit != null)
            return false;
        if (rewardTitle != null ? !rewardTitle.equals(that.rewardTitle) : that.rewardTitle != null) return false;
        if (rewardImage != null ? !rewardImage.equals(that.rewardImage) : that.rewardImage != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = loyaltyRewardId;
        result = 31 * result + retailerId;
        result = 31 * result + (visitTime != null ? visitTime.hashCode() : 0);
        result = 31 * result + (pointsPerVisit != null ? pointsPerVisit.hashCode() : 0);
        result = 31 * result + (rewardTitle != null ? rewardTitle.hashCode() : 0);
        result = 31 * result + (rewardImage != null ? rewardImage.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}
