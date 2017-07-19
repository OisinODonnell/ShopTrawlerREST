package org.fyp.repository;

import org.fyp.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;



//@RepositoryRestResource(collectionResourceRel = "zone", path = "Zones")
@Transactional
public interface ZoneRepository extends JpaRepository<Zone,Integer> {
    Collection<Zone> findAllByBeaconId(int beaconID);
    Zone findByZoneId(int zoneID);
    Integer deleteByZoneId(int zoneID);
}

