package org.fyp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

//@RepositoryRestResource(collectionResourceRel = "retailer", path = "Retailers")
@Transactional
public interface RetailerRepository extends JpaRepository<Retailer, Integer> {
    Retailer findByRetailerID(Integer retailerID);
    Integer deleteByRetailerID(Integer retailerID);
}
