package com.example.bootcampmicroservice.domain.spi;

import com.example.bootcampmicroservice.domain.model.VersionModel;

import java.time.LocalDate;
import java.util.List;

public interface IVersionPersistencePort {

    VersionModel saveVersion(VersionModel version);

    List<VersionModel> getAllVersionsByBootcampId(String startDate, Integer maxCapacity, Long bootcampId, String orderBy, Integer page, Integer size);

}