package com.example.bootcampmicroservice.infrastructure.out.jpa.mapper;

import com.example.bootcampmicroservice.domain.model.VersionModel;
import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.VersionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface VersionEntityMapper {

    @Mapping(target = "bootcampEntity", source = "bootcamp")
    VersionEntity toEntity(VersionModel versionModel);

    @Mapping(target = "bootcamp", source = "bootcampEntity")
    VersionModel toModel(VersionEntity bootcampEntity);

//    Set<CapacityEntity> toCapacityEntityList(Set<CapacityModel> capacitiesModel);
//
//    Set<CapacityModel> toCapacityModelList(Set<CapacityEntity> capacitiesEntity);
//
//    List<BootcampModel> toModelList(List<BootcampEntity> bootcampEntity);
//
//    @Mapping(target = "technologiesEntity", source = "technologies")
//    CapacityEntity toTechnologyEntity(CapacityModel capacityModel);
//
//    @Mapping(target = "technologies", source = "technologiesEntity")
//    CapacityModel toTechnologyModel(CapacityEntity capacityEntity);

}