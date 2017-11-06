package com.sudtechnologies.config.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author SudTechnologies
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ConflictRequestException() {}

    public ConflictRequestException(String message) {
        super(message);
    }

    public ConflictRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
