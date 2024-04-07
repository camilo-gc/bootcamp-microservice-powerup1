package com.example.bootcampmicroservice.application.handler;

import com.example.bootcampmicroservice.application.dto.TechnologyRequestDto;
import com.example.bootcampmicroservice.application.dto.TechnologyResponseDto;
import com.example.bootcampmicroservice.application.mapper.*;
import com.example.bootcampmicroservice.domain.api.ITechnologyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TechnologyHandlerImpl implements ITechnologyHandler {

    private final ITechnologyServicePort technologyServicePort;
    private final TechnologyRequestMapper technologyRequestMapper;
//    private final TechnologyResponseMapper technologyResponseMapper;

    @Override
    public void saveTechnology(TechnologyRequestDto technologyRequestDto) {
        technologyServicePort.saveTechnology(
                technologyRequestMapper.toModel(technologyRequestDto)
        );
    }

//    @Override
//    public List<TechnologyResponseDto> getAllTechnologies() {
//        return technologyResponseMapper.toResponseList(technologyServicePort.getAllTechnologies());
//    }

}