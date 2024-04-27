package com.example.bootcampmicroservice.infrastructure.out.jpa.mapper;

import com.example.bootcampmicroservice.domain.model.BootcampModel;
import com.example.bootcampmicroservice.domain.model.CapacityModel;
import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.BootcampEntity;
import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.CapacityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BootcampEntityMapper {

    @Mapping(target = "capacitiesEntity", source = "capacities")
    BootcampEntity toEntity(BootcampModel bootcampModel);

    @Mapping(target = "capacities", source = "capacitiesEntity")
    BootcampModel toModel(BootcampEntity bootcampEntity);

    Set<CapacityEntity> toCapacityEntityList(Set<CapacityModel> capacitiesModel);

    Set<CapacityModel> toCapacityModelList(Set<CapacityEntity> capacitiesEntity);

    List<BootcampModel> toModelList(List<BootcampEntity> bootcampEntity);

    @Mapping(target = "technologiesEntity", source = "technologies")
    CapacityEntity toTechnologyEntity(CapacityModel capacityModel);

    @Mapping(target = "technologies", source = "technologiesEntity")
    CapacityModel toTechnologyModel(CapacityEntity capacityEntity);

}