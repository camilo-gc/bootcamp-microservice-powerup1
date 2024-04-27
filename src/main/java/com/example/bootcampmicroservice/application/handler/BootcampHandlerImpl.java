package com.example.bootcampmicroservice.application.handler;

import com.example.bootcampmicroservice.application.dto.request.BootcampRequestDto;
import com.example.bootcampmicroservice.application.dto.response.BootcampResponseDto;
import com.example.bootcampmicroservice.application.mapper.BootcampRequestMapper;
import com.example.bootcampmicroservice.application.mapper.BootcampResponseMapper;
import com.example.bootcampmicroservice.domain.api.IBootcampServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BootcampHandlerImpl implements IBootcampHandler {

    private final IBootcampServicePort bootcampServicePort;
    private final BootcampRequestMapper bootcampRequestMapper;
    private final BootcampResponseMapper bootcampResponseMapper;

    @Override
    public void saveBootcamp(BootcampRequestDto bootcampRequestDto) {
        bootcampServicePort.saveBootcamp(
                bootcampRequestMapper.toModel(bootcampRequestDto)
        );
    }

    @Override
    public List<BootcampResponseDto> getAllBootcamps(String orderBy, Integer numberCapacities, Integer page, Integer size) {
        return bootcampResponseMapper.toResponseList(bootcampServicePort.getAllBootcamps(orderBy, numberCapacities, page, size));
    }

}