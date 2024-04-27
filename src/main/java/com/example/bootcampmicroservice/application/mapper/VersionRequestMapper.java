package com.example.bootcampmicroservice.application.mapper;

import com.example.bootcampmicroservice.application.dto.request.VersionRequestDto;
import com.example.bootcampmicroservice.domain.model.VersionModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface VersionRequestMapper {

    @Mapping(target = "bootcamp.id", source = "bootcampId")
    VersionModel toModel(VersionRequestDto versionRequestDto);

}