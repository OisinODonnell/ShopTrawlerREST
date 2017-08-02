package org.fyp.repository;

import org.fyp.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


@Transactional
public interface ImageRepository extends JpaRepository<Image, Integer> {
    Image findByImageid(int imageID);
}
