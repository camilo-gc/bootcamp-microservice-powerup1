package com.example.bootcampmicroservice.application.handler;

import com.example.bootcampmicroservice.application.dto.BootcampRequestDto;

public interface IBootcampHandler {

    void saveBootcamp(BootcampRequestDto bootcampRequestDto);

//    List<CapacityResponseDto> getAllTechnologies(String orderBy, Integer numberTechnologies, Integer page, Integer size);

}