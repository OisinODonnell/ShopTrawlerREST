package org.fyp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class LoyaltyRewardPK implements Serializable {
    private int retailerid;
    private int loyaltyRewardid;

    @Column(name = "retailerid", nullable = false)
    @Id
    public int getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(int retailerid) {
        this.retailerid = retailerid;
    }

    @Column(name = "loyalty_rewardid", nullable = false)
    @Id
    public int getLoyaltyRewardid() {
        return loyaltyRewardid;
    }

    public void setLoyaltyRewardid(int loyaltyRewardid) {
        this.loyaltyRewardid = loyaltyRewardid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoyaltyRewardPK that = (LoyaltyRewardPK) o;

        if (retailerid != that.retailerid) return false;
        if (loyaltyRewardid != that.loyaltyRewardid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = retailerid;
        result = 31 * result + loyaltyRewardid;
        return result;
    }
}
