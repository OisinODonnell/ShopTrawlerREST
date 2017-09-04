package org.fyp.repository;

import org.fyp.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "visit", path = "Visits")
@Transactional
public interface VisitRepository extends JpaRepository<Visit, Integer> {
    Collection<Visit> findAllByUserid(Integer userID);
    Collection<Visit> findAllByZoneid(Integer zoneID);
    Collection<Visit> findByEntryTimeBetween(Timestamp start, Timestamp end);
    Integer countByZoneidAndEntryTimeBetween(Integer zoneID, Timestamp startTime, Timestamp endTime);
    Integer countByEntryTimeIsBetween(Timestamp startTime, Timestamp endTime);
    Collection<Visit>findAllByEntryTimeIsBetween (Timestamp startTime, Timestamp endTime);
    Integer countAllByEntryTimeIsBetween(Timestamp startTime, Timestamp endTime);
    Integer deleteByVisitid(int visitID);
    
}
