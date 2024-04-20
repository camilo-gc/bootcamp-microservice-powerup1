package com.example.bootcampmicroservice.domain.usecase;

import com.example.bootcampmicroservice.domain.api.IBootcampServicePort;
import com.example.bootcampmicroservice.domain.exception.MaxCapacitiesException;
import com.example.bootcampmicroservice.domain.exception.MinCapacitiesException;
import com.example.bootcampmicroservice.domain.model.BootcampModel;
import com.example.bootcampmicroservice.domain.spi.IBootcampPersistencePort;

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

//    @Override
//    public List<CapacityModel> getAllCapacities(String orderBy, Integer numberTechnologies, Integer page, Integer size) {
//        List<CapacityModel> capacityModelList = capacityPersistencePort.getAllCapacities(orderBy, numberTechnologies, page, size);
//        if (numberTechnologies!=null && numberTechnologies !=0) {
//            return capacityModelList.stream()
//                    .filter(capacityEntity -> capacityEntity.getTechnologies().size() == numberTechnologies)
//                    .toList();
//        }
//        return capacityModelList;
//    }

}