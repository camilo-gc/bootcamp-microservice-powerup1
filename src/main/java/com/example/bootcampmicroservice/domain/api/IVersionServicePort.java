package com.example.bootcampmicroservice.domain.api;

import com.example.bootcampmicroservice.domain.model.VersionModel;

public interface IVersionServicePort {

    VersionModel saveVersion(VersionModel versionModel);

//    List<BootcampModel> getAllBootcamps(String orderBy, Integer numberCapacities, Integer page, Integer size);

}