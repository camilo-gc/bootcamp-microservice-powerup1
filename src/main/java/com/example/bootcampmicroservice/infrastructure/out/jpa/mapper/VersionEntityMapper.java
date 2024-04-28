package com.example.bootcampmicroservice.infrastructure.out.jpa.mapper;

import com.example.bootcampmicroservice.domain.model.VersionModel;
import com.example.bootcampmicroservice.infrastructure.out.jpa.entity.VersionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface VersionEntityMapper {

    @Mapping(target = "bootcampEntity", source = "bootcamp")
    VersionEntity toEntity(VersionModel versionModel);

    @Mapping(target = "bootcamp", source = "bootcampEntity")
    VersionModel toModel(VersionEntity bootcampEntity);

    List<VersionModel> toModelList(List<VersionEntity> bootcampEntity);

}