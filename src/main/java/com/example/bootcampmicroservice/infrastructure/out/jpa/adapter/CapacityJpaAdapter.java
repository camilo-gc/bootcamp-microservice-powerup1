package com.example.bootcampmicroservice.infrastructure.out.jpa.adapter;

import com.example.bootcampmicroservice.domain.model.CapacityModel;
import com.example.bootcampmicroservice.domain.model.TechnologyModel;
import com.example.bootcampmicroservice.domain.spi.ICapacityPersistencePort;
import com.example.bootcampmicroservice.infrastructure.exception.TechnologyNameAlreadyExistsException;
import com.example.bootcampmicroservice.infrastructure.out.jpa.mapper.CapacityEntityMapper;
import com.example.bootcampmicroservice.infrastructure.out.jpa.repository.ICapacityRepository;
import lombok.RequiredArgsConstructor;

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

//    @Override
//    public List<TechnologyModel> getAllTechnologies(String orderBy, Integer page, Integer size) {
//        List<TechnologyEntity> technologyEntityList;
//        if (orderBy.equals("ASC")){
//            technologyEntityList = technologyRepository.findAll(PageRequest.of(page, size, Sort.by("name").ascending())).toList();
//        } else {
//            technologyEntityList = technologyRepository.findAll(PageRequest.of(page, size, Sort.by("name").descending())).toList();
//        }
//        if (technologyEntityList.isEmpty()) {
//            throw new NoDataFoundException();
//        }
//        return technologyMapper.toTechnologyList(technologyEntityList);
//    }

}
