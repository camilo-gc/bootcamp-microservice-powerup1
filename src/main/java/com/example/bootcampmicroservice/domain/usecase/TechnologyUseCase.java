package com.example.bootcampmicroservice.domain.usecase;

import com.example.bootcampmicroservice.domain.api.ITechnologyServicePort;
import com.example.bootcampmicroservice.domain.model.TechnologyModel;
import com.example.bootcampmicroservice.domain.spi.ITechnologyPersistencePort;

import java.util.List;

public class TechnologyUseCase implements ITechnologyServicePort {

    private final ITechnologyPersistencePort technologyPersistencePort;

    public TechnologyUseCase(ITechnologyPersistencePort technologyPersistencePort) {
        this.technologyPersistencePort = technologyPersistencePort;
    }

    @Override
    public TechnologyModel saveTechnology(TechnologyModel technologyModel) {
        return technologyPersistencePort.saveTechnology(technologyModel);
    }

//    @Override
//    public List<TechnologyModel> getAllTechnologies() {
//        return technologyPersistencePort.getAllTechnologies();
//    }

}