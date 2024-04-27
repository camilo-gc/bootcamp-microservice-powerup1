package com.example.bootcampmicroservice.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechnologyResponseDto {
    private Long id;
    private String name;
    private String description;
}