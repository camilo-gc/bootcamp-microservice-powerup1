package com.example.bootcampmicroservice.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BootcampResponseDto {
    private Long id;
    private String name;
    private String description;
    private Set<CapacityBootcampResponseDto> capacities;
}