package com.maxi.backschool.services.exceptions;

public class EntityCreateViolationException extends RuntimeException {

    public EntityCreateViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityCreateViolationException(String message) {
        super(message);
    }

}
