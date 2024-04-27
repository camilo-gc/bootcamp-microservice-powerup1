package com.example.bootcampmicroservice.application.handler;

import com.example.bootcampmicroservice.application.dto.request.BootcampRequestDto;
import com.example.bootcampmicroservice.application.dto.response.BootcampResponseDto;

import java.util.List;

public interface IBootcampHandler {

    void saveBootcamp(BootcampRequestDto bootcampRequestDto);

    List<BootcampResponseDto> getAllBootcamps(String orderBy, Integer numberCapacities, Integer page, Integer size);

}