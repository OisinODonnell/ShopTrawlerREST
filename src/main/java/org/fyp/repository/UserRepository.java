package org.fyp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import org.fyp.model.User;

//@RepositoryRestResource(collectionResourceRel = "user", path = "Users")
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    Collection<User> findAllByOrderId(int orderId);
    User findByOrderIdAndStockItemId(int orderId, int stockItemId);
    Integer deleteByOrderIdAndStockItemId(int orderId, int stockItemId);
}
