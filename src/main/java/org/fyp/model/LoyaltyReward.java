package org.fyp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "loyaltyrewards", schema = "shoptrawler")
public class LoyaltyReward extends BaseEntity {
    private int       loyaltyRewardid;
    private Timestamp endDate;
    private Integer   pointsPerVisit;
    private Integer   retailerid;
    private String    rewardImage;
    private String    rewardTitle;
    private Timestamp startDate;
    private Integer   visitTime;
    private boolean   approved;

    @JsonBackReference
    private Retailer  retailersByRetailerid;

    public LoyaltyReward( ) {
    }


    public LoyaltyReward( List<String> attributes)  {
        this.retailerid         = toInteger(attributes.get(0));
        this.loyaltyRewardid    = toInteger(attributes.get(1));
        this.endDate            = toTimestamp(attributes.get(2));
        this.pointsPerVisit     = toInteger(attributes.get(3));
        this.rewardImage        = attributes.get(4);
        this.rewardTitle        = attributes.get(5);
        this.startDate          = toTimestamp(attributes.get(6));
        this.visitTime          = toInteger(attributes.get(7));
        this.approved           = toBoolean(attributes.get(8));

    }
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
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
    @Column(name = "retailerid", nullable = true)
    public Integer getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(Integer retailerid) {
        this.retailerid = retailerid;
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
    @Column(name = "reward_title", nullable = true, length = 255)
    public String getRewardTitle() {
        return rewardTitle;
    }

    public void setRewardTitle(String rewardTitle) {
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

    public boolean getApproved( ) {
        return approved;
    }

    public void setApproved( boolean approved ) {
        this.approved = approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoyaltyReward that = (LoyaltyReward) o;

        if (loyaltyRewardid != that.loyaltyRewardid) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (pointsPerVisit != null ? !pointsPerVisit.equals(that.pointsPerVisit) : that.pointsPerVisit != null)
            return false;
        if (retailerid != null ? !retailerid.equals(that.retailerid) : that.retailerid != null) return false;
        if (rewardImage != null ? !rewardImage.equals(that.rewardImage) : that.rewardImage != null) return false;
        if (rewardTitle != null ? !rewardTitle.equals(that.rewardTitle) : that.rewardTitle != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (visitTime != null ? !visitTime.equals(that.visitTime) : that.visitTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = loyaltyRewardid;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (pointsPerVisit != null ? pointsPerVisit.hashCode() : 0);
        result = 31 * result + (retailerid != null ? retailerid.hashCode() : 0);
        result = 31 * result + (rewardImage != null ? rewardImage.hashCode() : 0);
        result = 31 * result + (rewardTitle != null ? rewardTitle.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (visitTime != null ? visitTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "retailerid", referencedColumnName = "retailerid",insertable = false, updatable = false)
    public Retailer getRetailersByRetailerid() {
        return retailersByRetailerid;
    }

    public void setRetailersByRetailerid(Retailer retailersByRetailerid) {
        this.retailersByRetailerid = retailersByRetailerid;
    }
}
