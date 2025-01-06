package com.robot.runnerz.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceNotFoundException extends RuntimeException {
    private final HttpStatus status;

    private final ErrorStatus errorStatus;

    public ResourceNotFoundException(String message, HttpStatus status, ErrorStatus errorStatus) {
        super(message);
        this.status = status;
        this.errorStatus = errorStatus;
    }
}
