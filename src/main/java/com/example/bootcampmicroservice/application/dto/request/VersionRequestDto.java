package com.example.bootcampmicroservice.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@Setter
public class VersionRequestDto {

    private Long id;

    @NotNull
    @JsonProperty(value = "bootcamp_id")
    private Long bootcampId;

    @NotNull
    @JsonProperty(value = "start_date")
    private LocalDate startDate;

    @NotNull
    @JsonProperty(value = "end_date")
    private LocalDate endDate;

    @NotNull
    @JsonProperty(value = "max_capacity")
    private Integer maxCapacity;

}