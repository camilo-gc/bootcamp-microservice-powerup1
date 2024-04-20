package com.example.bootcampmicroservice.domain.spi;

import com.example.bootcampmicroservice.domain.model.CapacityModel;

import java.util.List;

public interface ICapacityPersistencePort {

    CapacityModel saveCapacity(CapacityModel capacityModel);

    List<CapacityModel> getAllCapacities(String orderBy, Integer numberTechnologies, Integer page, Integer size);

}