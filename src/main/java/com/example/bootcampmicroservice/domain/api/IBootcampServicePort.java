package com.example.bootcampmicroservice.domain.api;

import com.example.bootcampmicroservice.domain.model.BootcampModel;

import java.util.List;

public interface IBootcampServicePort {

    BootcampModel saveBootcamp(BootcampModel capacityModel);

    List<BootcampModel> getAllBootcamps(String orderBy, Integer numberCapacities, Integer page, Integer size);

}