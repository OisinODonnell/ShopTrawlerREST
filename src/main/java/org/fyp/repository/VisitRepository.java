package org.fyp.repository;

import org.fyp.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.transaction.Transactional;
import java.util.Collection;


//@RepositoryRestResource(collectionResourceRel = "visit", path = "Visits")
@Transactional
public interface VisitRepository extends JpaRepository<Visit, Integer> {
    Collection<Visit> findAllByUserid(int userID);
    Collection<Visit> findAllByZoneid(int zoneID);

    Integer deleteByVisitid(int visitID);
    
}
