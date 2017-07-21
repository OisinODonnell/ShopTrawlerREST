package org.fyp.repository;

import org.fyp.model.Beacon;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

//@RepositoryRestResource(collectionResourceRel = "beacon", path = "Beacons")
@Transactional
public interface BeaconRepository extends JpaRepository<Beacon, Integer> {
    Beacon findByBeaconid(int beaconID);
    Integer deleteByBeaconid(int beaconID);

}