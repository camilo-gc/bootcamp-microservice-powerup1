package com.example.bootcampmicroservice.application.mapper;

import com.example.bootcampmicroservice.application.dto.CapacityResponseDto;
import com.example.bootcampmicroservice.application.dto.TechnologyResponseDto;
import com.example.bootcampmicroservice.domain.model.CapacityModel;
import com.example.bootcampmicroservice.domain.model.TechnologyModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CapacityResponseMapper {

    CapacityResponseDto toResponse(CapacityModel technologyModel);

    List<CapacityResponseDto> toResponseList(List<CapacityModel> technologyModel);

}