package org.fyp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

//@RepositoryRestResource(collectionResourceRel = "user", path = "Users")
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserID(int userID);
    Integer deleteByUserID(int userID);
}
