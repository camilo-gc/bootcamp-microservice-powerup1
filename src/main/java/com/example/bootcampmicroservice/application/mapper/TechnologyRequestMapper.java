package com.example.bootcampmicroservice.application.mapper;

import com.example.bootcampmicroservice.application.dto.TechnologyRequestDto;
import com.example.bootcampmicroservice.domain.model.TechnologyModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TechnologyRequestMapper {

//    @Mapping(target = "nameTechnology", source = "name")
//    @Mapping(target = "description.id", source = "descriptionId")
    TechnologyModel toModel(TechnologyRequestDto technologyRequestDto);

}