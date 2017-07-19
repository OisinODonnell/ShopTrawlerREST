package org.fyp.repository;

import org.fyp.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.transaction.Transactional;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "location", path = "Locations")
@Transactional
public interface LocationRepository extends JpaRepository<Location, Integer> {
    Collection<Location> findAllByShoppingCentreId(int shoppingCentreID);

}
