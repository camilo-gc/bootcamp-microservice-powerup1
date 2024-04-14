package com.example.bootcampmicroservice.infrastructure.exceptionhandler;

public enum ExceptionResponse {
    NO_DATA_FOUND("No data found for the requested petition"),
    TECHNOLOGY_ALREADY_EXISTS("name of the technology already exists"),
    MIN_TECHNOLOGIES_ALLOWED("Minimum number of technologies not allowed"),
    MAX_TECHNOLOGIES_ALLOWED("Maximum number of technologies not allowed");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}