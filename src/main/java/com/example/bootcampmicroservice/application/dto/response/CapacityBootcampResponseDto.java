package com.example.bootcampmicroservice.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CapacityBootcampResponseDto {
    private Long id;
    private String name;
    private Set<TechnologyCapacityResponseDto> technologies;
}