package com.maxi.backschool.services.exceptions;

public class EntitySearchNotFoundException extends RuntimeException {

    public EntitySearchNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntitySearchNotFoundException(String message) {
        super(message);
    }
}
