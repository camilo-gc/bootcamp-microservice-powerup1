package com.example.bootcampmicroservice.application.handler;

import com.example.bootcampmicroservice.application.dto.CapacityRequestDto;
import com.example.bootcampmicroservice.application.dto.CapacityResponseDto;
import com.example.bootcampmicroservice.application.dto.TechnologyRequestDto;
import com.example.bootcampmicroservice.application.dto.TechnologyResponseDto;

import java.util.List;

public interface ICapacityHandler {

    void saveCapacity(CapacityRequestDto capacityRequestDto);

    List<CapacityResponseDto> getAllTechnologies(String orderBy, Integer numberTechnologies, Integer page, Integer size);

}