package org.fyp.repository;

import org.fyp.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;


//@RepositoryRestResource(collectionResourceRel = "content", path = "Contents")
@Transactional
public interface ContentRepository extends JpaRepository<Content, Integer> {

    Content findByContentid(Integer contentID);
    Collection<Content> findAllByRetailerid(int retailerID);
    
//    Collection<Content> findByTitleLikeIgnoreCase(String titleLike);

    Integer deleteByContentid(int contentID);
}
