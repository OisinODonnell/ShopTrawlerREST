package org.fyp.repository;

import org.fyp.model.Content;
import org.fyp.model.LoyaltyReward;
import org.fyp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

//@RepositoryRestResource(collectionResourceRel = "content", path = "Contents")
@Transactional
public interface ContentRepository extends JpaRepository<Content, Integer> {

    Content findByContentid(Integer contentID);
    Collection<Content> findAllByRetailerid(int retailerID);
    Content findByRetaileridAndStartDateBeforeAndEndDateAfter( int retailerid, Timestamp nowStart, Timestamp nowEnd);
    Integer deleteByContentid(int contentID);
    Collection<Content> findAllByApproved( boolean state);
    Collection<Content> findByRetailerid(int retailerID);
    Integer countByRetaileridAndStartDateBetween(int retailerid, Timestamp startDate, Timestamp endDate);
    Integer countByRetaileridAndEndDateBetween(int retailerid, Timestamp startDate, Timestamp endDate);

    List<Content> findByRetaileridAndStartDateBetween(int  retailerid, Timestamp startDate, Timestamp endDate);
    List<Content> findByRetaileridAndEndDateBetween(int  retailerid, Timestamp startDate, Timestamp endDate);
    List<Content> findByRetaileridAndStartDateLessThanEqualAndStartDateLessThanEqualAndEndDateGreaterThanEqualAndEndDateGreaterThanEqual(int  retailerid, Timestamp startDate1, Timestamp endDate1, Timestamp startDate2, Timestamp endDate2);
    List<Content> findAllByRetaileridAndEndDateAfterOrderByStartDate(int retailerID, Timestamp endDate);

}
