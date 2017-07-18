package org.fyp.repository;

import org.fyp.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


//@RepositoryRestResource(collectionResourceRel = "visit", path = "Visits")
@Transactional
public interface VisitRepository extends JpaRepository<Visit, Integer> {
    Collection<Visit> findAllByUserID(int userID);
    Collection<Visit> findAllByZoneID(int zoneID);
    Collection<Visit> findByRetailerIDAndUserID(int retailerID, int userID );

    Integer deleteByVisitID(int visitID);
    
}
