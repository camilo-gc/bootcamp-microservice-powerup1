package com.example.bootcampmicroservice.domain.spi;

import com.example.bootcampmicroservice.domain.model.TechnologyModel;

import java.util.List;

public interface ITechnologyPersistencePort {

    TechnologyModel saveTechnology(TechnologyModel technologyModel);

    List<TechnologyModel> getAllTechnologies(String orderBy, Integer page, Integer size);

}