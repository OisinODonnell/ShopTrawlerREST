package org.fyp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "favourite", path = "Favourites")
@Transactional
public interface FavouriteRepository extends JpaRepository<Favourite, Integer> {
    Collection<Favourite> findAllByUserID(int userID);
    Favourite findByFavouriteID (int favouriteID);
    Integer deleteByFavouriteID(int favouriteID);

}
