package org.fyp.repository;

import org.fyp.model.UserPoint;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.transaction.Transactional;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "userPoint", path = "UserPoints")
@Transactional
public interface UserPointRepository extends JpaRepository<UserPoint, Integer> {
    Collection<UserPoint> findAllByRetailerid(int retailerID);
    Collection<UserPoint> findAllByUserid(int userID);
    UserPoint findByRetaileridAndUserid( int retailerID, int userID );
    Integer deleteByUseridAndRetailerid(Integer userID, Integer retailerID);

}
