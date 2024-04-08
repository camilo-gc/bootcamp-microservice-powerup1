package com.example.bootcampmicroservice.domain.api;

import com.example.bootcampmicroservice.domain.model.CapacityModel;
import com.example.bootcampmicroservice.domain.model.TechnologyModel;

import java.util.List;

public interface ICapacityServicePort {

    CapacityModel saveCapacity(CapacityModel capacityModel);

//    List<TechnologyModel> getAllTechnologies(String orderBy, Integer page, Integer size);

}