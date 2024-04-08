package com.example.bootcampmicroservice.infrastructure.input.rest;

import com.example.bootcampmicroservice.application.dto.CapacityRequestDto;
import com.example.bootcampmicroservice.application.handler.ICapacityHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/capacity")
@RequiredArgsConstructor
public class CapacityRestController {

    private final ICapacityHandler capacityHandler;

    @Operation(summary = "Add a new technology")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Technology created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Technology already exists", content = @Content)
    })
    @PostMapping("")
    public ResponseEntity<Void> saveCapacity(@Valid @RequestBody CapacityRequestDto capacityRequestDto) {
        capacityHandler.saveCapacity(capacityRequestDto);
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
//    public ResponseEntity<List<TechnologyResponseDto>> getAllPokemonFromPokedex(@RequestParam(defaultValue = "ASC") String orderBy, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
//        return ResponseEntity.ok(technologyHandler.getAllTechnologies(orderBy, page, size));
//    }

}