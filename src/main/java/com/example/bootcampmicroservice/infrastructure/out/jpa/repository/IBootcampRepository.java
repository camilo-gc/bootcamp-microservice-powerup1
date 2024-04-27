package com.example.bootcampmicroservice.infrastructure.out.jpa.repository;

import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.BootcampEntity;
import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.CapacityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBootcampRepository extends JpaRepository<BootcampEntity, Long> {

    //metodo personalizado para traerme la data filtrada

}