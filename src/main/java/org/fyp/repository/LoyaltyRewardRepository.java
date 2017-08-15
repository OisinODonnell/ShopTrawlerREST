package org.fyp.repository;

import org.fyp.model.LoyaltyReward;
import org.fyp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "loyaltyReward", path = "LoyaltyRewards")
@Transactional
public interface LoyaltyRewardRepository extends JpaRepository<LoyaltyReward, Integer> {
    Collection<LoyaltyReward> findAllByRetailerid(int retailerID);
    LoyaltyReward findByLoyaltyRewardid(int loyaltyRewardID);
    LoyaltyReward findByRetailerid(int retailerID);
    LoyaltyReward findByRetaileridAndStartDateBeforeAndEndDateAfter(int loyaltyRewardID, Timestamp nowStart, Timestamp nowEnd);
    Collection<LoyaltyReward> findAllByApproved( byte state);
    Integer deleteByLoyaltyRewardid(int loyaltyRewardID);


}
