package com.example.bootcampmicroservice.infrastructure.out.jpa.adapter;

import com.example.bootcampmicroservice.domain.model.TechnologyModel;
import com.example.bootcampmicroservice.domain.spi.ITechnologyPersistencePort;
import com.example.bootcampmicroservice.infrastructure.exception.NoDataFoundException;
import com.example.bootcampmicroservice.infrastructure.exception.TechnologyNameAlreadyExistsException;
import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.TechnologyEntity;
import com.example.bootcampmicroservice.infrastructure.out.jpa.mapper.TechnologyMapper;
import com.example.bootcampmicroservice.infrastructure.out.jpa.repository.ITechnologyRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TechnologyJpaAdapter implements ITechnologyPersistencePort {

    private final ITechnologyRepository technologyRepository;
    private final TechnologyMapper technologyMapper;

    @Override
    public TechnologyModel saveTechnology(TechnologyModel technologyModel) {

        TechnologyModel model = technologyMapper.toModel(technologyRepository.findByName(technologyModel.getName()));
        if (model != null) throw new TechnologyNameAlreadyExistsException();
        return technologyMapper.toModel(
                technologyRepository.save( technologyMapper.toEntity(technologyModel) )
        );
    }

//    @Override
//    public List<TechnologyModel> getAllTechnologies() {
//        List<TechnologyEntity> technologyEntityList = technologyRepository.findAll();
//        if (technologyEntityList.isEmpty()) {
//            throw new NoDataFoundException();
//        }
//        return technologyMapper.toTechnologyList(technologyEntityList);
//    }

}
