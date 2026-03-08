package com.allan_dev.Event.infra.exceptions;

public class EventNotFound extends RuntimeException {
    public EventNotFound(String message) {
        super(message);
    }
}
