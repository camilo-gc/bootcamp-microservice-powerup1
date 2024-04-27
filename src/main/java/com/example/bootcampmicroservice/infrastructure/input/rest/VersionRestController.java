package com.example.bootcampmicroservice.infrastructure.input.rest;

import com.example.bootcampmicroservice.application.dto.request.VersionRequestDto;
import com.example.bootcampmicroservice.application.handler.IVersionHandler;
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
@RequestMapping("/version")
@RequiredArgsConstructor
public class VersionRestController {

    private final IVersionHandler versionHandler;

    @Operation(summary = "Add a new bootcamp version")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Version created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Version already exists", content = @Content)
    })
    @PostMapping("")
    public ResponseEntity<Void> saveVersion(@Valid @RequestBody VersionRequestDto versionRequestDto) {
        versionHandler.saveVersion(versionRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
//
//    @Operation(summary = "Get all the Bootcamps")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "All bootcamps returned",
//                    content = @Content(mediaType = "application/json",
//                            array = @ArraySchema(schema = @Schema(implementation = BootcampResponseDto.class)))),
//            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
//    })
//    @GetMapping("/all")
//    public ResponseEntity<List<BootcampResponseDto>> getAllBootcamps(@RequestParam(defaultValue = "ASC") String orderBy, @RequestParam @Nullable Integer numberCapacities, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
//        return ResponseEntity.ok(versionHandler.getAllBootcamps(orderBy, numberCapacities, page, size));
//    }

}