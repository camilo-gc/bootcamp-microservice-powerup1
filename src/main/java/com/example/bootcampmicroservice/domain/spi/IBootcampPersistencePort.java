package com.example.bootcampmicroservice.domain.spi;

import com.example.bootcampmicroservice.domain.model.BootcampModel;

public interface IBootcampPersistencePort {

    BootcampModel saveBootcamp(BootcampModel bootcampModel);

//    List<CapacityModel> getAllCapacities(String orderBy, Integer numberTechnologies, Integer page, Integer size);

}