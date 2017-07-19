package org.fyp.repository;

import org.fyp.model.LoyaltyReward;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "loyaltyReward", path = "LoyaltyRewards")
@Transactional
public interface LoyaltyRewardRepository extends JpaRepository<LoyaltyReward, Integer> {
    Collection<LoyaltyReward> findAllByRetailerid(int retailerID);
    LoyaltyReward findByLoyaltyRewardid(int loyaltyRewardID);
    Integer deleteByLoyaltyRewardid(int loyaltyRewardID);
}
