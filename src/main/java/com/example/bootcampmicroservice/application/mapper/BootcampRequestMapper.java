package com.example.bootcampmicroservice.application.mapper;

import com.example.bootcampmicroservice.application.dto.request.BootcampRequestDto;
import com.example.bootcampmicroservice.domain.model.BootcampModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BootcampRequestMapper {

    BootcampModel toModel(BootcampRequestDto capacityRequestDto);

}