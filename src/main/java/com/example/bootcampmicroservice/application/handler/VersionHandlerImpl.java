package com.example.bootcampmicroservice.application.handler;

import com.example.bootcampmicroservice.application.dto.request.VersionRequestDto;
import com.example.bootcampmicroservice.application.dto.response.VersionResponseDto;
import com.example.bootcampmicroservice.application.mapper.VersionRequestMapper;
import com.example.bootcampmicroservice.application.mapper.VersionResponseMapper;
import com.example.bootcampmicroservice.domain.api.IVersionServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VersionHandlerImpl implements IVersionHandler {

    private final IVersionServicePort versionServicePort;
    private final VersionRequestMapper versionRequestMapper;
    private final VersionResponseMapper versionResponseMapper;

    @Override
    public void saveVersion(VersionRequestDto versionRequestDto) {
        versionServicePort.saveVersion(
                versionRequestMapper.toModel(versionRequestDto)
        );
    }

    @Override
    public List<VersionResponseDto> getAllVersions(String startDate, Integer maxCapacity, Long bootcampId, String orderBy, Integer page, Integer size) {
        return versionResponseMapper.toResponseList(versionServicePort.getAllVersions(startDate, maxCapacity, bootcampId,orderBy,page, size));
    }

}