package com.example.bootcampmicroservice.application.mapper;

import com.example.bootcampmicroservice.application.dto.response.BootcampResponseDto;
import com.example.bootcampmicroservice.domain.model.BootcampModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BootcampResponseMapper {

    BootcampResponseDto toResponse(BootcampModel bootcampModel);

    List<BootcampResponseDto> toResponseList(List<BootcampModel> bootcampModelList);

}