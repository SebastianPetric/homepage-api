package com.sebastian.homepage.api.domain.core.exception;

import java.util.Date;

public class ErrorMessage {
    private final Date timestamp;
    private final String message;
    private final String rejectedValue;

    private final String rejectedField;

    public ErrorMessage(Date timestamp, String message, String rejectedField, String rejectedValue) {
        this.timestamp = timestamp;
        this.message = message;
        this.rejectedValue = rejectedValue;
        this.rejectedField = rejectedField;
    }


    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getRejectedValue() {
        return rejectedValue;
    }

    public String getRejectedField() {
        return rejectedField;
    }
}
