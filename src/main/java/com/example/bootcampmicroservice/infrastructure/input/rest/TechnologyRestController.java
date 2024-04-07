package com.example.bootcampmicroservice.infrastructure.input.rest;

import com.example.bootcampmicroservice.application.dto.TechnologyRequestDto;
import com.example.bootcampmicroservice.application.dto.TechnologyResponseDto;
import com.example.bootcampmicroservice.application.handler.ITechnologyHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/technology")
@RequiredArgsConstructor
public class TechnologyRestController {

    private final ITechnologyHandler technologyHandler;

    @Operation(summary = "Add a new technology")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Technology created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Technology already exists", content = @Content)
    })
    @PostMapping("")
    public ResponseEntity<Void> saveTechnology(@Valid @RequestBody TechnologyRequestDto technologyRequestDto) {
        technologyHandler.saveTechnology(technologyRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

//    @Operation(summary = "Get all the Technologies")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "All technologies returned",
//                    content = @Content(mediaType = "application/json",
//                            array = @ArraySchema(schema = @Schema(implementation = TechnologyResponseDto.class)))),
//            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
//    })
//    @GetMapping("/all")
//    public ResponseEntity<List<TechnologyResponseDto>> getAllPokemonFromPokedex() {
//        return ResponseEntity.ok(technologyHandler.getAllTechnologies());
//    }

}