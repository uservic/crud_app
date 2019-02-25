package com.andersen.javatrainee.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Duplicate found")
public class DuplicateFoundException extends RuntimeException {

    public DuplicateFoundException(String message) {
        super("Duplicate found: " + message);
    }

}