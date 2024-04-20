package com.example.bootcampmicroservice.domain.api;

import com.example.bootcampmicroservice.domain.model.CapacityModel;

import java.util.List;

public interface ICapacityServicePort {

    CapacityModel saveCapacity(CapacityModel capacityModel);

    List<CapacityModel> getAllCapacities(String orderBy, Integer numberTechnologies, Integer page, Integer size);

}