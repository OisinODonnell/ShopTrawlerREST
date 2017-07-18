package org.fyp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "rating", path = "Ratings")
@Transactional
public interface RatingRepository extends JpaRepository<Rating,Integer> {
    Collection<Rating> findAllByRetailerID(int retailerID);
    Rating findByUserID(int userID);

}

