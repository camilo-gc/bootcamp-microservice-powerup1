package com.example.bootcampmicroservice.infrastructure.out.jpa.repository;

import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.VersionEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IVersionRepository extends JpaRepository<VersionEntity, Long> {


    /*
    select * from public."version" v
    where v.bootcamp_id = 2
    and (v.startdate = null or v.startdate = '2024-05-06')
    and (v.maxcapacity = null or v.maxcapacity = 300)
    */
    @Query("SELECT v " +
            "FROM VersionEntity v " +
            "WHERE (:bootcampId is null OR v.bootcampEntity.id = :bootcampId) " +
            "AND (:startDate is null OR to_char(v.startDate, 'YYYY-MM-DD') LIKE :startDate) " +
            "AND (:maxCapacity is null OR v.maxCapacity = :maxCapacity)"
            )
    List<VersionEntity> findAllVersionsByStartDateOrMaxCapacityOrBootcampId(String startDate, Integer maxCapacity, Long bootcampId, Pageable pageable);

}