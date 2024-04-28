package com.example.bootcampmicroservice.domain.api;

import com.example.bootcampmicroservice.domain.model.VersionModel;

import java.time.LocalDate;
import java.util.List;

public interface IVersionServicePort {

    VersionModel saveVersion(VersionModel versionModel);

    List<VersionModel> getAllVersions(String startDate, Integer maxCapacity, Long bootcampId, String orderBy, Integer page, Integer size);

}