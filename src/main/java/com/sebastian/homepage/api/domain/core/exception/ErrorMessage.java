package com.sebastian.homepage.api.domain.core.exception;

import java.util.Date;

public class ErrorMessage {
    private final Date timestamp;
    private final String message;
    private final String description;

    public ErrorMessage(Date timestamp, String message, String description) {
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }


    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
