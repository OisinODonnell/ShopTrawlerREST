package org.fyp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "bonusCode", path = "BonusCode")
@Transactional
public interface BonusCodeRepository extends JpaRepository<BonusCode, Integer> {
    Collection<BonusCode> findAllByUserID(int userID);
    Collection<BonusCode> findAllByRetailerID(int retailerID);
    BonusCode findByUserIDAndRetailerID( int userID, int retailerID );
}
