package org.fyp.repository;

import org.fyp.model.LoyaltyReward;
import org.fyp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "loyaltyReward", path = "LoyaltyRewards")
@Transactional
public interface LoyaltyRewardRepository extends JpaRepository<LoyaltyReward, Integer> {
    Collection<LoyaltyReward> findAllByRetailerid(int retailerID);

    LoyaltyReward findByLoyaltyRewardid(int loyaltyRewardID);
    LoyaltyReward findByRetaileridAndStartDateBeforeAndEndDateAfter(int retailerID, Timestamp nowStart, Timestamp nowEnd);
    LoyaltyReward findByRetaileridAndStartDateBefore(int retailerID, Timestamp nowStart);
    Collection<LoyaltyReward> findAllByApproved( boolean state);
    Integer deleteByLoyaltyRewardid(int loyaltyRewardID);
    List<LoyaltyReward> findAll();
    Collection<LoyaltyReward> findByRetailerid(int retailerID);
    // check date ranges
    List<LoyaltyReward> findByRetaileridAndStartDateBetween(int retailerID, Timestamp startDate, Timestamp endDate);
    List<LoyaltyReward> findByRetaileridAndEndDateBetween(int retailerID, Timestamp startDate, Timestamp endDate);
    List<LoyaltyReward> findAllByRetaileridAndEndDateAfterOrderByStartDate(int retailerID, Timestamp endDate);
    List<LoyaltyReward> findByRetaileridAndStartDateLessThanEqualAndStartDateLessThanEqualAndEndDateGreaterThanEqualAndEndDateGreaterThanEqual(int retailerID, Timestamp startDate1, Timestamp endDate1, Timestamp startDate2, Timestamp endDate2);
}
