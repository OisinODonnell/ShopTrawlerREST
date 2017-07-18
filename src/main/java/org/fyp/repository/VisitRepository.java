package org.fyp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "visit", path = "Visits")
@Transactional
public interface VisitRepository extends JpaRepository<Visit, Integer> {
    Collection<Visit> findAllByUserId(int userId);
    Collection<Visit> findAllByZoneId(int zoneId);
    Collection<Visit> findByZoneIdAndUserId( int zoneId, int userId );
    Collection<Visit> findByRetailerIdAndUserId( int retailerId, int userId );
    Visit findByZoneIdAndUserId( int accountId, int stockItemId );

    Integer deleteByVisitId(int visitId);
    
}
