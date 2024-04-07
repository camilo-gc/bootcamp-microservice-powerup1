package com.example.bootcampmicroservice.infrastructure.out.jpa.mapper;

import com.example.bootcampmicroservice.domain.model.TechnologyModel;
import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.TechnologyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TechnologyMapper {

    TechnologyEntity toEntity(TechnologyModel technologyModel);

    TechnologyModel toModel(TechnologyEntity technologyEntity);

    List<TechnologyModel> toTechnologyList(List<TechnologyEntity> technologyEntityList);

}