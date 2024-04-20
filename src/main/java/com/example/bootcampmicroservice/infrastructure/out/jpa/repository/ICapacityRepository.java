package com.example.bootcampmicroservice.infrastructure.out.jpa.repository;

import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.CapacityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICapacityRepository extends JpaRepository<CapacityEntity, Long> {



}