package com.sebastian.homepage.api.domain.core.exception;

public class FriendlyCaptchaUnavailableException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FriendlyCaptchaUnavailableException() {
        super("Der Friendly Captcha Service kann diese Anfrage aktuell nicht validieren. Bitte versuchen Sie es zu einem späteren Zeitpunkt, oder schreiben Sie direkt an die oben angegebene Adresse.");
    }
}
