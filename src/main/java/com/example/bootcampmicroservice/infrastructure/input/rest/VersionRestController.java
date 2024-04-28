package com.example.bootcampmicroservice.infrastructure.input.rest;

import com.example.bootcampmicroservice.application.dto.request.VersionRequestDto;
import com.example.bootcampmicroservice.application.dto.response.VersionResponseDto;
import com.example.bootcampmicroservice.application.handler.IVersionHandler;
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
import java.time.LocalDate;
import java.util.List;

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

    @Operation(summary = "Get all the Versions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All versions returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = VersionResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/all")
    public ResponseEntity<List<VersionResponseDto>> getAllBootcamps(@RequestParam @Nullable String startDate,
                                                                    @RequestParam @Nullable Integer maxCapacity,
                                                                    @RequestParam @Nullable Long bootcampId,
                                                                    @RequestParam(defaultValue = "ASC") String orderBy,
                                                                    @RequestParam(defaultValue = "0") Integer page,
                                                                    @RequestParam(defaultValue = "5") Integer size) {
        return ResponseEntity.ok(versionHandler.getAllVersions(startDate, maxCapacity, bootcampId, orderBy, page, size));
    }

}