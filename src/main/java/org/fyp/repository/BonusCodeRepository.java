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
    BonusCode findByUseridAndRetailerid(int userID, int retailerID );
    Integer deleteByBonusCodeid(int bonusCodeID);
    // count where the userid field is empty (bonus codes not used yet)
    Integer countAllByRetaileridAndUseridNull(Integer retailerID);
    BonusCode findByBonusCodeid(Integer bonusCodeID);
}
