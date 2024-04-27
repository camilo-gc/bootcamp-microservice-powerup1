package com.example.bootcampmicroservice.application.handler;

import com.example.bootcampmicroservice.application.dto.request.TechnologyRequestDto;
import com.example.bootcampmicroservice.application.dto.response.TechnologyResponseDto;

import java.util.List;

public interface ITechnologyHandler {

    void saveTechnology(TechnologyRequestDto technologyRequestDto);

    List<TechnologyResponseDto> getAllTechnologies(String orderBy, Integer page, Integer size);

}