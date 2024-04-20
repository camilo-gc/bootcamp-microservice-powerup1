package com.example.bootcampmicroservice.infrastructure.out.jpa.adapter;

import com.example.bootcampmicroservice.domain.model.CapacityModel;
import com.example.bootcampmicroservice.domain.spi.ICapacityPersistencePort;
import com.example.bootcampmicroservice.infrastructure.exception.NoDataFoundException;
import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.CapacityEntity;
import com.example.bootcampmicroservice.infrastructure.out.jpa.mapper.CapacityEntityMapper;
import com.example.bootcampmicroservice.infrastructure.out.jpa.repository.ICapacityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class CapacityJpaAdapter implements ICapacityPersistencePort {

    private final ICapacityRepository capacityRepository;
    private final CapacityEntityMapper capacityEntityMapper;

    @Override
    public CapacityModel saveCapacity(CapacityModel capacityModel) {
        return capacityEntityMapper.toModel(
                capacityRepository.save( capacityEntityMapper.toEntity(capacityModel) )
        );
    }

    @Override
    public List<CapacityModel> getAllCapacities(String orderBy, Integer numberTechnologies, Integer page, Integer size){
        List<CapacityEntity> capacityEntityList;
        if (orderBy.equals("ASC")){
            capacityEntityList = capacityRepository.findAll(PageRequest.of(page, size, Sort.by("name").ascending())).toList();
        } else {
            capacityEntityList = capacityRepository.findAll(PageRequest.of(page, size, Sort.by("name").descending())).toList();
        }
        if (capacityEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }

        return capacityEntityMapper.toModelList(
                capacityEntityList
        );
    }

}
