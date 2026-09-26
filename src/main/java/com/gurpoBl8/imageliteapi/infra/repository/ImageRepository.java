package com.gurpoBl8.imageliteapi.infra.repository;

import com.gurpoBl8.imageliteapi.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {

}
