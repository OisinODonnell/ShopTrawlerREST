package org.fyp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

//@RepositoryRestResource(collectionResourceRel = "beacon", path = "Beacons")
@Transactional
public interface BeaconRepository extends JpaRepository<Beacon, Integer> {
    Beacon findByBeaconId(int beaconID);
    Integer deleteByBeaconId(int beaconID);

}