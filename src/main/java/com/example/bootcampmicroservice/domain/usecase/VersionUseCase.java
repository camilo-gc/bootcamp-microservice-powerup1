package com.example.bootcampmicroservice.domain.usecase;

import com.example.bootcampmicroservice.domain.api.IVersionServicePort;
import com.example.bootcampmicroservice.domain.exception.EndDateNotAllowedException;
import com.example.bootcampmicroservice.domain.model.VersionModel;
import com.example.bootcampmicroservice.domain.spi.IVersionPersistencePort;

import java.time.LocalDate;
import java.util.List;

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

    @Override
    public List<VersionModel> getAllVersions(String startDate, Integer maxCapacity, Long bootcampId, String orderBy, Integer page, Integer size) {
        return versionPersistencePort.getAllVersionsByBootcampId(startDate, maxCapacity, bootcampId, orderBy, page, size);
    }

}