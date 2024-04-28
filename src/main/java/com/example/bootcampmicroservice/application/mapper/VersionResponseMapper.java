package com.example.bootcampmicroservice.application.mapper;

import com.example.bootcampmicroservice.application.dto.response.BootcampResponseDto;
import com.example.bootcampmicroservice.application.dto.response.VersionResponseDto;
import com.example.bootcampmicroservice.domain.model.BootcampModel;
import com.example.bootcampmicroservice.domain.model.VersionModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VersionResponseMapper {

    VersionResponseDto toResponse(VersionModel versionModel);

    List<VersionResponseDto> toResponseList(List<VersionModel> bootcampModelList);

}