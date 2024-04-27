package com.example.bootcampmicroservice.infrastructure.exceptionhandler;

import com.example.bootcampmicroservice.domain.exception.*;
import com.example.bootcampmicroservice.infrastructure.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "Message";

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

    @ExceptionHandler(TechnologyNameAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleTechnologyNameAlreadyExistsException(
            TechnologyNameAlreadyExistsException technologyNameAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.TECHNOLOGY_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(MinTechnologiesException.class)
    public ResponseEntity<Map<String, String>> handleMinTechnologiesException(
            MinTechnologiesException maxTechnologiesException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.MIN_TECHNOLOGIES_ALLOWED.getMessage()));
    }

    @ExceptionHandler(MaxTechnologiesException.class)
    public ResponseEntity<Map<String, String>> handleMaxTechnologiesException(
            MaxTechnologiesException maxTechnologiesException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.MAX_TECHNOLOGIES_ALLOWED.getMessage()));
    }

    @ExceptionHandler(MinCapacitiesException.class)
    public ResponseEntity<Map<String, String>> handleMinCapacitiesException(
            MinCapacitiesException minCapacitiesException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.MIN_CAPACITIES_ALLOWED.getMessage()));
    }

    @ExceptionHandler(MaxCapacitiesException.class)
    public ResponseEntity<Map<String, String>> handleMaxCapacitiesException(
            MaxCapacitiesException maxCapacitiesException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.MAX_CAPACITIES_ALLOWED.getMessage()));
    }

    @ExceptionHandler(EndDateNotAllowedException.class)
    public ResponseEntity<Map<String, String>> handleDateException(
            EndDateNotAllowedException endDateNotAllowedException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.END_DATE_NOT_ALLOWED.getMessage()));
    }
}