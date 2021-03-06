package org.fyp.repository;

import org.fyp.model.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "retailer", path = "Retailers")
@Transactional
public interface RetailerRepository extends JpaRepository<Retailer, Integer> {
    Retailer findByRetailerid(Integer retailerID);
    Collection<Retailer> findAllByRetailerid( Integer retailerID);
    Retailer findByManagerid(Integer managerID);
    Integer deleteByRetailerid(Integer retailerID);
}
