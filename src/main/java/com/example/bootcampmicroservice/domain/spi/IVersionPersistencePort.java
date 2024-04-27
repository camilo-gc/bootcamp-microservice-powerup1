package com.example.bootcampmicroservice.domain.spi;

import com.example.bootcampmicroservice.domain.model.VersionModel;

public interface IVersionPersistencePort {

    VersionModel saveVersion(VersionModel version);

//    List<BootcampModel> getAllBootcamps(String orderBy, Integer numberCapacities, Integer page, Integer size);

}