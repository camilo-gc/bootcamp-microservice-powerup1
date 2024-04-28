package com.example.bootcampmicroservice.application.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VersionResponseDto {
    private Long id;
    private BootcampVersionResponseDto bootcamp;
    @JsonProperty(value = "start_date")
    private String startDate;
    @JsonProperty(value = "end_date")
    private String endDate;
    @JsonProperty(value = "max_capacity")
    private Integer maxCapacity;
}