package com.sebastian.homepage.api.domain.core.exception;

public class FriendlyCaptchaUnavailableException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FriendlyCaptchaUnavailableException() {
        super("Friendly Captcha Service currently unavailable. Can't validate request right now. Please try later again.");
    }
}
