package com.example.bootcampmicroservice.application.handler;

import com.example.bootcampmicroservice.application.dto.request.VersionRequestDto;

import java.util.List;

public interface IVersionHandler {

    void saveVersion(VersionRequestDto versionRequestDto);

//    List<BootcampResponseDto> getAllBootcamps(String orderBy, Integer numberCapacities, Integer page, Integer size);

}