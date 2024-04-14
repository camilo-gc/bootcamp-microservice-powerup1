package com.example.bootcampmicroservice.domain.api;

import com.example.bootcampmicroservice.domain.model.CapacityModel;

public interface ICapacityServicePort {

    CapacityModel saveCapacity(CapacityModel capacityModel);

//    List<TechnologyModel> getAllTechnologies(String orderBy, Integer page, Integer size);

}