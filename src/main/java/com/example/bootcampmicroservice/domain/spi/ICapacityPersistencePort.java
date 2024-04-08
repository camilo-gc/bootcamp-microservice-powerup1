package com.example.bootcampmicroservice.domain.spi;

import com.example.bootcampmicroservice.domain.model.CapacityModel;
import com.example.bootcampmicroservice.domain.model.TechnologyModel;

import java.util.List;

public interface ICapacityPersistencePort {

    CapacityModel saveCapacity(CapacityModel capacityModel);

//    List<TechnologyModel> getAllTechnologies(String orderBy, Integer page, Integer size);

}