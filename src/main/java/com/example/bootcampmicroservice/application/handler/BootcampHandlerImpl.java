package com.example.bootcampmicroservice.application.handler;

import com.example.bootcampmicroservice.application.dto.BootcampRequestDto;
import com.example.bootcampmicroservice.application.mapper.BootcampRequestMapper;
import com.example.bootcampmicroservice.domain.api.IBootcampServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BootcampHandlerImpl implements IBootcampHandler {

    private final IBootcampServicePort bootcampServicePort;
    private final BootcampRequestMapper bootcampRequestMapper;
//    private final CapacityResponseMapper capacityResponseMapper;

    @Override
    public void saveBootcamp(BootcampRequestDto bootcampRequestDto) {
        bootcampServicePort.saveBootcamp(
                bootcampRequestMapper.toModel(bootcampRequestDto)
        );
    }

//    @Override
//    public List<CapacityResponseDto> getAllTechnologies(String orderBy, Integer numberTechnologies, Integer page, Integer size) {
//        return capacityResponseMapper.toResponseList(capacityServicePort.getAllCapacities(orderBy, numberTechnologies, page, size));
//    }

}