package org.fyp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "zone", path = "Zones")
@Transactional
public interface ZoneRepository extends JpaRepository<Zone,Integer> {
    Collection<Zone> findAllByShoppingCentreID(int shoppingCentreID);
    Collection<Zone> findAllByLocationID(int locationID);
    Collection<Zone> findAllByBeaconID(int beaconID);
    Zone findByZoneID(int zoneID);
    Integer deleteByZoneID(int zoneID);
}

