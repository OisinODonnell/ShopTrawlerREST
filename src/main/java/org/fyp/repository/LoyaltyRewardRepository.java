package org.fyp.repository;

import org.fyp.model.LoyaltyReward;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "loyaltyReward", path = "LoyaltyRewards")
@Transactional
public interface LoyaltyRewardRepository extends JpaRepository<LoyaltyReward, Integer> {
    Collection<LoyaltyReward> findAllByUserID(int userID);
    Collection<LoyaltyReward> findAllByRetailerID(int retailerID);
    LoyaltyReward findByLoyaltyRewardID(int loyaltyRewardID);
    Integer deleteByLoyaltyRewardID(int loyaltyRewardID);
}
