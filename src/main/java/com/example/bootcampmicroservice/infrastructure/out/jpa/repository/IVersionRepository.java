package com.example.bootcampmicroservice.infrastructure.out.jpa.repository;

import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.VersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVersionRepository extends JpaRepository<VersionEntity, Long> {

    //metodo personalizado para traerme la data filtrada

}