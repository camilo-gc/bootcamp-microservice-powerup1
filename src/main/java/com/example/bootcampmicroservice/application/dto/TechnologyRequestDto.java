package com.example.bootcampmicroservice.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class TechnologyRequestDto {
    @JsonIgnore
    private Long id;
    @NotNull
    @NotBlank
    @NotEmpty
    @Max(value = 50, message = "La longitud del nombre debe ser de máximo 50 caracteres")
    private String name;

    @NotNull
    @NotBlank
    @NotEmpty
    @Max(value = 90, message = "La longitud de la descripcion debe ser de máximo 50 caracteres")
    private String description;

}