package org.fyp.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "loyaltyrewards", schema = "shoptrawler", catalog = "")
@IdClass(LoyaltyRewardPK.class)
public class LoyaltyReward {
    private int retailerid;
    private int loyaltyRewardid;
    private Timestamp endDate;
    private Integer pointsPerVisit;
    private String rewardImage;
    private Integer rewardTitle;
    private Timestamp startDate;
    private Integer visitTime;

    @Id
    @Column(name = "retailerid", nullable = false)
    public int getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(int retailerid) {
        this.retailerid = retailerid;
    }

    @Id
    @Column(name = "loyalty_rewardid", nullable = false)
    public int getLoyaltyRewardid() {
        return loyaltyRewardid;
    }

    public void setLoyaltyRewardid(int loyaltyRewardid) {
        this.loyaltyRewardid = loyaltyRewardid;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "points_per_visit", nullable = true)
    public Integer getPointsPerVisit() {
        return pointsPerVisit;
    }

    public void setPointsPerVisit(Integer pointsPerVisit) {
        this.pointsPerVisit = pointsPerVisit;
    }

    @Basic
    @Column(name = "reward_image", nullable = true, length = 255)
    public String getRewardImage() {
        return rewardImage;
    }

    public void setRewardImage(String rewardImage) {
        this.rewardImage = rewardImage;
    }

    @Basic
    @Column(name = "reward_title", nullable = true)
    public Integer getRewardTitle() {
        return rewardTitle;
    }

    public void setRewardTitle(Integer rewardTitle) {
        this.rewardTitle = rewardTitle;
    }

    @Basic
    @Column(name = "start_date", nullable = true)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "visit_time", nullable = true)
    public Integer getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Integer visitTime) {
        this.visitTime = visitTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoyaltyReward that = (LoyaltyReward) o;

        if (retailerid != that.retailerid) return false;
        if (loyaltyRewardid != that.loyaltyRewardid) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (pointsPerVisit != null ? !pointsPerVisit.equals(that.pointsPerVisit) : that.pointsPerVisit != null)
            return false;
        if (rewardImage != null ? !rewardImage.equals(that.rewardImage) : that.rewardImage != null) return false;
        if (rewardTitle != null ? !rewardTitle.equals(that.rewardTitle) : that.rewardTitle != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (visitTime != null ? !visitTime.equals(that.visitTime) : that.visitTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = retailerid;
        result = 31 * result + loyaltyRewardid;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (pointsPerVisit != null ? pointsPerVisit.hashCode() : 0);
        result = 31 * result + (rewardImage != null ? rewardImage.hashCode() : 0);
        result = 31 * result + (rewardTitle != null ? rewardTitle.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (visitTime != null ? visitTime.hashCode() : 0);
        return result;
    }
}
