package com.example.bootcampmicroservice.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
public class CapacitiesBootcampRequestDto {

    @NotNull
    private Long id;

}