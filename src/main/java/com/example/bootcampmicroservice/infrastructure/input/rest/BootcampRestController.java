package com.example.bootcampmicroservice.infrastructure.input.rest;

import com.example.bootcampmicroservice.application.dto.request.BootcampRequestDto;
import com.example.bootcampmicroservice.application.dto.response.BootcampResponseDto;
import com.example.bootcampmicroservice.application.handler.IBootcampHandler;
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
@RequestMapping("/bootcamp")
@RequiredArgsConstructor
public class BootcampRestController {

    private final IBootcampHandler bootcampHandler;

    @Operation(summary = "Add a new bootcamp")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Bootcamp created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Bootcamp already exists", content = @Content)
    })
    @PostMapping("")
    public ResponseEntity<Void> saveBootcamp(@Valid @RequestBody BootcampRequestDto bootcampRequestDto) {
        bootcampHandler.saveBootcamp(bootcampRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @Operation(summary = "Get all the Bootcamps")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All bootcamps returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = BootcampResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/all")
    public ResponseEntity<List<BootcampResponseDto>> getAllBootcamps(@RequestParam(defaultValue = "ASC") String orderBy, @RequestParam @Nullable Integer numberCapacities, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        return ResponseEntity.ok(bootcampHandler.getAllBootcamps(orderBy, numberCapacities, page, size));
    }

}