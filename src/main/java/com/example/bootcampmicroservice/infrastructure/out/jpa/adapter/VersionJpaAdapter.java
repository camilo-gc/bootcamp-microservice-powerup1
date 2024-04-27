package com.example.bootcampmicroservice.infrastructure.out.jpa.adapter;

import com.example.bootcampmicroservice.domain.model.VersionModel;
import com.example.bootcampmicroservice.domain.spi.IVersionPersistencePort;
import com.example.bootcampmicroservice.infrastructure.out.jpa.mapper.VersionEntityMapper;
import com.example.bootcampmicroservice.infrastructure.out.jpa.repository.IVersionRepository;
import lombok.RequiredArgsConstructor;

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

//    @Override
//    public List<BootcampModel> getAllBootcamps(String orderBy, Integer numberCapacities, Integer page, Integer size){
//        List<BootcampEntity> bootcampEntityList;
//        if (orderBy.equals("ASC")){
//            bootcampEntityList = bootcampRepository.findAll(PageRequest.of(page, size, Sort.by("name").ascending())).toList();
//        } else {
//            bootcampEntityList = bootcampRepository.findAll(PageRequest.of(page, size, Sort.by("name").descending())).toList();
//        }
//
//        if (bootcampEntityList.isEmpty()) {
//            throw new NoDataFoundException();
//        }
//
//        return bootcampEntityMapper.toModelList(
//                bootcampEntityList
//        );
//    }

}
