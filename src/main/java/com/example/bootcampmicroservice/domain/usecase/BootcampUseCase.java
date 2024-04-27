package com.example.bootcampmicroservice.domain.usecase;

import com.example.bootcampmicroservice.domain.api.IBootcampServicePort;
import com.example.bootcampmicroservice.domain.exception.MaxCapacitiesException;
import com.example.bootcampmicroservice.domain.exception.MinCapacitiesException;
import com.example.bootcampmicroservice.domain.model.BootcampModel;
import com.example.bootcampmicroservice.domain.spi.IBootcampPersistencePort;

import java.util.List;

public class BootcampUseCase implements IBootcampServicePort {

    private final IBootcampPersistencePort bootcampPersistencePort;

    public BootcampUseCase(IBootcampPersistencePort bootcampPersistencePort) {
        this.bootcampPersistencePort = bootcampPersistencePort;
    }

    @Override
    public BootcampModel saveBootcamp(BootcampModel bootcampModel) {
        if (bootcampModel.getCapacities().isEmpty()) throw new MinCapacitiesException();
        if (bootcampModel.getCapacities().size()>4) throw new MaxCapacitiesException();
        return bootcampPersistencePort.saveBootcamp(bootcampModel);
    }

    @Override
    public List<BootcampModel> getAllBootcamps(String orderBy, Integer numberCapacities, Integer page, Integer size) {
        List<BootcampModel> bootcampModelList = bootcampPersistencePort.getAllBootcamps(orderBy, numberCapacities, page, size);
        if (numberCapacities!=null && numberCapacities !=0) {
            return bootcampModelList.stream()
                    .filter(bootcampEntity -> bootcampEntity.getCapacities().size() == numberCapacities)
                    .toList();
        }
        return bootcampModelList;
    }

}