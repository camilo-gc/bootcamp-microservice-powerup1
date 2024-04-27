package com.example.bootcampmicroservice.infrastructure.out.jpa.adapter;

import com.example.bootcampmicroservice.domain.model.BootcampModel;
import com.example.bootcampmicroservice.domain.spi.IBootcampPersistencePort;
import com.example.bootcampmicroservice.infrastructure.exception.NoDataFoundException;
import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.BootcampEntity;
import com.example.bootcampmicroservice.infrastructure.out.jpa.mapper.BootcampEntityMapper;
import com.example.bootcampmicroservice.infrastructure.out.jpa.repository.IBootcampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

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

    @Override
    public List<BootcampModel> getAllBootcamps(String orderBy, Integer numberCapacities, Integer page, Integer size){
        List<BootcampEntity> bootcampEntityList;
        if (orderBy.equals("ASC")){
            bootcampEntityList = bootcampRepository.findAll(PageRequest.of(page, size, Sort.by("name").ascending())).toList();
        } else {
            bootcampEntityList = bootcampRepository.findAll(PageRequest.of(page, size, Sort.by("name").descending())).toList();
        }

        if (bootcampEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }

        return bootcampEntityMapper.toModelList(
                bootcampEntityList
        );
    }

}
