package com.example.bootcampmicroservice.infrastructure.out.jpa.adapter;

import com.example.bootcampmicroservice.domain.model.VersionModel;
import com.example.bootcampmicroservice.domain.spi.IVersionPersistencePort;
import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.VersionEntity;
import com.example.bootcampmicroservice.infrastructure.out.jpa.mapper.VersionEntityMapper;
import com.example.bootcampmicroservice.infrastructure.out.jpa.repository.IVersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class VersionJpaAdapter implements IVersionPersistencePort {

    private final IVersionRepository versionRepository;
    private final VersionEntityMapper versionEntityMapper;

    @Override
    public VersionModel saveVersion(VersionModel version) {
        return versionEntityMapper.toModel(
                versionRepository.save( versionEntityMapper.toEntity(version) )
        );
    }

    @Override
    public List<VersionModel> getAllVersionsByBootcampId(String startDate, Integer maxCapacity, Long bootcampId, String orderBy, Integer page, Integer size) {
        LocalDate date = startDate != null ? LocalDate.parse(startDate) : null;
        Sort sort = orderBy.equals("ASC") ? Sort.by("bootcampEntity.name").ascending() : Sort.by("bootcampEntity.name").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        List<VersionEntity> versionEntityList = versionRepository.findAllVersionsByStartDateOrMaxCapacityOrBootcampId(startDate, maxCapacity, bootcampId, pageable);

        return versionEntityMapper.toModelList(versionEntityList);
    }

}
