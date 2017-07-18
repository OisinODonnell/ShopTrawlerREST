package org.fyp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;


//@RepositoryRestResource(collectionResourceRel = "content", path = "Contents")
@Transactional
public interface ContentRepository extends JpaRepository<Content, Integer> {

    Content findByContentID(Integer contentID);
    Collection<Content> findAllByRetailerID(int retailerID);
    
//    Collection<Content> findByTitleLikeIgnoreCase(String titleLike);

    Integer deleteByContentID(int contentID);
}
