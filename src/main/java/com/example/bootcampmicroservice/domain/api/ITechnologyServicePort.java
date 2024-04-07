package com.example.bootcampmicroservice.domain.api;

import com.example.bootcampmicroservice.domain.model.TechnologyModel;

import java.util.List;

public interface ITechnologyServicePort {

    TechnologyModel saveTechnology(TechnologyModel technologyModel);

//    List<TechnologyModel> getAllTechnologies();

}