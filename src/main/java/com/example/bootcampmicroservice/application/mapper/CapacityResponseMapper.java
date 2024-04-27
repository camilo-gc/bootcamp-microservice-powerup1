package com.example.bootcampmicroservice.application.mapper;

import com.example.bootcampmicroservice.application.dto.response.CapacityResponseDto;
import com.example.bootcampmicroservice.domain.model.CapacityModel;
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