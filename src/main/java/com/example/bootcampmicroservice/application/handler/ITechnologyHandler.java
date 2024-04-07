package com.example.bootcampmicroservice.application.handler;

import com.example.bootcampmicroservice.application.dto.TechnologyRequestDto;
import com.example.bootcampmicroservice.application.dto.TechnologyResponseDto;

import java.util.List;

public interface ITechnologyHandler {

    void saveTechnology(TechnologyRequestDto technologyRequestDto);

//    List<TechnologyResponseDto> getAllTechnologies();

}