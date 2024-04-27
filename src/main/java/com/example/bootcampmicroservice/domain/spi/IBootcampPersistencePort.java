package com.example.bootcampmicroservice.domain.spi;

import com.example.bootcampmicroservice.domain.model.BootcampModel;

import java.util.List;

public interface IBootcampPersistencePort {

    BootcampModel saveBootcamp(BootcampModel bootcampModel);

    List<BootcampModel> getAllBootcamps(String orderBy, Integer numberCapacities, Integer page, Integer size);

}