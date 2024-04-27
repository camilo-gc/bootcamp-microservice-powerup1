package com.example.bootcampmicroservice.infrastructure.input.rest;

import com.example.bootcampmicroservice.application.dto.request.CapacityRequestDto;
import com.example.bootcampmicroservice.application.dto.response.CapacityResponseDto;
import com.example.bootcampmicroservice.application.handler.ICapacityHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @Operation(summary = "Get all the Capacities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All capacities returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CapacityResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/all")
    public ResponseEntity<List<CapacityResponseDto>> getAllCapacities(@RequestParam(defaultValue = "ASC") String orderBy, @RequestParam @Nullable Integer numberTechnologies, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        return ResponseEntity.ok(capacityHandler.getAllTechnologies(orderBy, numberTechnologies, page, size));
    }

}