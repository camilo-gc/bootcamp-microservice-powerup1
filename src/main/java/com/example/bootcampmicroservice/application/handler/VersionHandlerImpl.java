package com.example.bootcampmicroservice.application.handler;

import com.example.bootcampmicroservice.application.dto.request.VersionRequestDto;
import com.example.bootcampmicroservice.application.mapper.VersionRequestMapper;
import com.example.bootcampmicroservice.domain.api.IVersionServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class VersionHandlerImpl implements IVersionHandler {

    private final IVersionServicePort versionServicePort;
    private final VersionRequestMapper versionRequestMapper;
//    private final BootcampResponseMapper bootcampResponseMapper;

    @Override
    public void saveVersion(VersionRequestDto versionRequestDto) {
        versionServicePort.saveVersion(
                versionRequestMapper.toModel(versionRequestDto)
        );
    }

//    @Override
//    public List<BootcampResponseDto> getAllBootcamps(String orderBy, Integer numberCapacities, Integer page, Integer size) {
//        return bootcampResponseMapper.toResponseList(bootcampServicePort.getAllBootcamps(orderBy, numberCapacities, page, size));
//    }

}