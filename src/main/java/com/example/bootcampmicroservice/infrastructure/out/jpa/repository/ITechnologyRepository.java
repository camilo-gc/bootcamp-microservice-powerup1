package com.example.bootcampmicroservice.infrastructure.out.jpa.repository;

import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.TechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechnologyRepository extends JpaRepository<TechnologyEntity, Long> {

    TechnologyEntity findByName(String name);

}