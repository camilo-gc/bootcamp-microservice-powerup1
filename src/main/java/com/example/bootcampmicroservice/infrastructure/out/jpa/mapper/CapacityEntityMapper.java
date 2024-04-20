package com.example.bootcampmicroservice.infrastructure.out.jpa.mapper;

import com.example.bootcampmicroservice.domain.model.CapacityModel;
import com.example.bootcampmicroservice.domain.model.TechnologyModel;
import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.CapacityEntity;
import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.TechnologyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CapacityEntityMapper {

    @Mapping(target = "technologiesEntity", source = "technologies")
    CapacityEntity toEntity(CapacityModel capacityModel);

    @Mapping(target = "technologies", source = "technologiesEntity")
    CapacityModel toModel(CapacityEntity capacityEntity);

    Set<TechnologyEntity> toTechnologyEntityList(Set<TechnologyModel> technologyEntityList);

    Set<TechnologyModel> toTechnologyModelList(Set<TechnologyEntity> technologyEntityList);

    List<CapacityModel> toModelList(List<CapacityEntity> capacityEntity);

}