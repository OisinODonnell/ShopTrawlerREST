package org.fyp.repository;

import org.fyp.model.ShoppingCentre;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

//@RepositoryRestResource(collectionResourceRel = "shoppingCentre", path = "ShoppingCentres")
@Transactional
public interface ShoppingCentreRepository extends JpaRepository<ShoppingCentre, Integer> {
    ShoppingCentre findByShoppingCentreId(Integer shoppingCentreID);

}
