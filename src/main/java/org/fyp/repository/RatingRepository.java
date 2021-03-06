package org.fyp.repository;

import org.fyp.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "rating", path = "Ratings")
@Transactional
public interface RatingRepository extends JpaRepository<Rating,Integer> {
    Collection<Rating> findAllByRetailerid(int retailerID);
    Collection<Rating> findAllByUserid(int userID);
    Rating findByUseridAndRetailerid(Integer userID, Integer retailerID);
    Integer deleteByUseridAndRetailerid(Integer ratingID, Integer retailerID);
}

