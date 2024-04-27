package com.example.bootcampmicroservice.application.handler;

import com.example.bootcampmicroservice.application.dto.request.CapacityRequestDto;
import com.example.bootcampmicroservice.application.dto.response.CapacityResponseDto;
import com.example.bootcampmicroservice.application.mapper.CapacityRequestMapper;
import com.example.bootcampmicroservice.application.mapper.CapacityResponseMapper;
import com.example.bootcampmicroservice.domain.api.ICapacityServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CapacityHandlerImpl implements ICapacityHandler {

    private final ICapacityServicePort capacityServicePort;
    private final CapacityRequestMapper capacityRequestMapper;
    private final CapacityResponseMapper capacityResponseMapper;

    @Override
    public void saveCapacity(CapacityRequestDto capacityRequestDto) {
        capacityServicePort.saveCapacity(
                capacityRequestMapper.toModel(capacityRequestDto)
        );
    }

    @Override
    public List<CapacityResponseDto> getAllTechnologies(String orderBy, Integer numberTechnologies, Integer page, Integer size) {
        return capacityResponseMapper.toResponseList(capacityServicePort.getAllCapacities(orderBy, numberTechnologies, page, size));
    }

}