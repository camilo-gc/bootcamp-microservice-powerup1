package com.example.bootcampmicroservice.infrastructure.out.jpa.adapter;

import com.example.bootcampmicroservice.domain.model.BootcampModel;
import com.example.bootcampmicroservice.domain.spi.IBootcampPersistencePort;
import com.example.bootcampmicroservice.infrastructure.out.jpa.mapper.BootcampEntityMapper;
import com.example.bootcampmicroservice.infrastructure.out.jpa.repository.IBootcampRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BootcampJpaAdapter implements IBootcampPersistencePort {

    private final IBootcampRepository bootcampRepository;
    private final BootcampEntityMapper bootcampEntityMapper;

    @Override
    public BootcampModel saveBootcamp(BootcampModel bootcampModel) {
        return bootcampEntityMapper.toModel(
                bootcampRepository.save( bootcampEntityMapper.toEntity(bootcampModel) )
        );
    }

//    @Override
//    public List<CapacityModel> getAllCapacities(String orderBy, Integer numberTechnologies, Integer page, Integer size){
//        List<CapacityEntity> capacityEntityList;
//        if (orderBy.equals("ASC")){
//            capacityEntityList = bootcampRepository.findAll(PageRequest.of(page, size, Sort.by("name").ascending())).toList();
//        } else {
//            capacityEntityList = bootcampRepository.findAll(PageRequest.of(page, size, Sort.by("name").descending())).toList();
//        }
//        if (capacityEntityList.isEmpty()) {
//            throw new NoDataFoundException();
//        }
//
//        return capacityEntityMapper.toModelList(
//                capacityEntityList
//        );
//    }

}
