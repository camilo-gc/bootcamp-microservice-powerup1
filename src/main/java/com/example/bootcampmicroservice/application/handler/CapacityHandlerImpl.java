package com.example.bootcampmicroservice.application.handler;

import com.example.bootcampmicroservice.application.dto.CapacityRequestDto;
import com.example.bootcampmicroservice.application.mapper.CapacityRequestMapper;
import com.example.bootcampmicroservice.domain.api.ICapacityServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CapacityHandlerImpl implements ICapacityHandler {

    private final ICapacityServicePort capacityServicePort;
    private final CapacityRequestMapper capacityRequestMapper;
//    private final TechnologyResponseMapper technologyResponseMapper;

    @Override
    public void saveCapacity(CapacityRequestDto capacityRequestDto) {
        capacityServicePort.saveCapacity(
                capacityRequestMapper.toModel(capacityRequestDto)
        );
    }

//    @Override
//    public List<TechnologyResponseDto> getAllTechnologies(String orderBy, Integer page, Integer size) {
//        return technologyResponseMapper.toResponseList(technologyServicePort.getAllTechnologies(orderBy, page, size));
//    }

}