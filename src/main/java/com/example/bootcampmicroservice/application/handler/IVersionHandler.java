package com.example.bootcampmicroservice.application.handler;

import com.example.bootcampmicroservice.application.dto.request.VersionRequestDto;
import com.example.bootcampmicroservice.application.dto.response.VersionResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface IVersionHandler {

    void saveVersion(VersionRequestDto versionRequestDto);

    List<VersionResponseDto> getAllVersions(String startDate, Integer maxCapacity, Long bootcampId, String orderBy, Integer page, Integer size);

}