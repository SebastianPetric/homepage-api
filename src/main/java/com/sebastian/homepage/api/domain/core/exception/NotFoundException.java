package com.sebastian.homepage.api.domain.core.exception;

import org.bson.types.ObjectId;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotFoundException(ObjectId id) {
        super("Object found with id: " + id);
    }
}
