package com.example.bootcampmicroservice.domain.api;

import com.example.bootcampmicroservice.domain.model.BootcampModel;

public interface IBootcampServicePort {

    BootcampModel saveBootcamp(BootcampModel capacityModel);

//    List<CapacityModel> getAllCapacities(String orderBy, Integer numberTechnologies, Integer page, Integer size);

}