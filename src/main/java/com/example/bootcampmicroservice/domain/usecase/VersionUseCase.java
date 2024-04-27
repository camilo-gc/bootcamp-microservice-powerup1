package com.example.bootcampmicroservice.domain.usecase;

import com.example.bootcampmicroservice.domain.api.IVersionServicePort;
import com.example.bootcampmicroservice.domain.exception.EndDateNotAllowedException;
import com.example.bootcampmicroservice.domain.model.VersionModel;
import com.example.bootcampmicroservice.domain.spi.IVersionPersistencePort;

public class VersionUseCase implements IVersionServicePort {

    private final IVersionPersistencePort versionPersistencePort;

    public VersionUseCase(IVersionPersistencePort versionPersistencePort) {
        this.versionPersistencePort = versionPersistencePort;
    }

    @Override
    public VersionModel saveVersion(VersionModel version) {
        if (version.getEndDate().isBefore(version.getStartDate())) throw new EndDateNotAllowedException();
        return versionPersistencePort.saveVersion(version);
    }

//    @Override
//    public List<BootcampModel> getAllBootcamps(String orderBy, Integer numberCapacities, Integer page, Integer size) {
//        List<BootcampModel> bootcampModelList = bootcampPersistencePort.getAllBootcamps(orderBy, numberCapacities, page, size);
//        if (numberCapacities!=null && numberCapacities !=0) {
//            return bootcampModelList.stream()
//                    .filter(bootcampEntity -> bootcampEntity.getCapacities().size() == numberCapacities)
//                    .toList();
//        }
//        return bootcampModelList;
//    }

}