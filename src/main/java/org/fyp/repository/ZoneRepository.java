package org.fyp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import org.fyp.model.Zone;
import org.springframework.transaction.annotation.Transactional;

//@RepositoryRestResource(collectionResourceRel = "zone", path = "Zones")
@Transactional
public interface ZoneRepository extends JpaRepository<Zone,Integer> {
    Collection<Zone> findAllByShoppingCentreID(int shoppingCentreID);
    Collection<Zone> findAllByLocationID(int locationID);
    Collection<Zone> findAllByBeaconID(int beaconID);
    Zone findByZoneID(int zoneID);
    Integer deleteByZoneID(int zoneID);
}

