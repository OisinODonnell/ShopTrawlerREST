package org.fyp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Oisin on 7/18/2017.
 */
public class LoyaltyRewardPK implements Serializable {
    private int loyaltyRewardId;
    private int retailerId;

    @Column(name = "loyaltyRewardID")
    @Id
    public int getLoyaltyRewardId() {
        return loyaltyRewardId;
    }

    public void setLoyaltyRewardId(int loyaltyRewardId) {
        this.loyaltyRewardId = loyaltyRewardId;
    }

    @Column(name = "retailerID")
    @Id
    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoyaltyRewardPK that = (LoyaltyRewardPK) o;

        if (loyaltyRewardId != that.loyaltyRewardId) return false;
        if (retailerId != that.retailerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = loyaltyRewardId;
        result = 31 * result + retailerId;
        return result;
    }
}
