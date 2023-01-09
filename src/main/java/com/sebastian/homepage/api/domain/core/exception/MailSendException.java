package com.sebastian.homepage.api.domain.core.exception;

public class MailSendException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MailSendException() {
        super("E-Mail konnte nicht versendet werden. Bitte versuchen Sie es zu einem späteren Zeitpunkt, oder schreiben Sie direkt an die oben angegebene Adresse.");
    }
}
