package com.example.bootcampmicroservice.application.handler;

import com.example.bootcampmicroservice.application.dto.request.CapacityRequestDto;
import com.example.bootcampmicroservice.application.dto.response.CapacityResponseDto;

import java.util.List;

public interface ICapacityHandler {

    void saveCapacity(CapacityRequestDto capacityRequestDto);

    List<CapacityResponseDto> getAllTechnologies(String orderBy, Integer numberTechnologies, Integer page, Integer size);

}