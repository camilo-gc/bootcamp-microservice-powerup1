package com.example.bootcampmicroservice.domain.usecase;

import com.example.bootcampmicroservice.domain.api.ICapacityServicePort;
import com.example.bootcampmicroservice.domain.exception.MaxTechnologiesException;
import com.example.bootcampmicroservice.domain.exception.MinTechnologiesException;
import com.example.bootcampmicroservice.domain.model.CapacityModel;
import com.example.bootcampmicroservice.domain.spi.ICapacityPersistencePort;

public class CapacityUseCase implements ICapacityServicePort {

    private final ICapacityPersistencePort capacityPersistencePort;

    public CapacityUseCase(ICapacityPersistencePort capacityPersistencePort) {
        this.capacityPersistencePort = capacityPersistencePort;
    }

    @Override
    public CapacityModel saveCapacity(CapacityModel capacityModel) {
        if (capacityModel.getTechnologies().size()<3) throw new MinTechnologiesException();
        if (capacityModel.getTechnologies().size()>20) throw new MaxTechnologiesException();
        return capacityPersistencePort.saveCapacity(capacityModel);
    }

//    @Override
//    public List<TechnologyModel> getAllTechnologies(String orderBy, Integer page, Integer size) {
//        return technologyPersistencePort.getAllTechnologies(orderBy, page, size);
//    }

}