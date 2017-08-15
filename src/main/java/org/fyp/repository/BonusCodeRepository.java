package org.fyp.repository;

import org.fyp.model.BonusCode;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "bonusCode", path = "BonusCode")
@Transactional
public interface BonusCodeRepository extends JpaRepository<BonusCode, Integer> {
    Collection<BonusCode> findAllByUserid(int userID);
    Collection<BonusCode> findAllByRetailerid(int retailerID);
    Collection<BonusCode> findAllByRetaileridAndUserid(int retailerID, int userID);
    BonusCode findByUseridAndRetailerid(int userID, int retailerID );
    Integer deleteByBonusCodeid(int bonusCodeID);
    Integer countAllBRetaileridAndUseridNull(Integer retailerID);
}
