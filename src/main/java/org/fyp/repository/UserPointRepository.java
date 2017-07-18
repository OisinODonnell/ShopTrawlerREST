package org.fyp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "userPoint", path = "UserPoints")
@Transactional
public interface UserPointRepository extends JpaRepository<UserPoint, Integer> {
    Collection<UserPoint> findAllByRetailerID(int retailerID);
    Collection<UserPoint> findAllByUserID(int userID);
    UserPoint findByRetailerIDAndUserID( int retailerID, int userID );

}
