package org.fyp.repository;

import org.fyp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

//@RepositoryRestResource(collectionResourceRel = "user", path = "Users")
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserid(int userID);
    Integer deleteByUserid(int userID);
}
