package com.sebastian.homepage.api.domain.core.friendlycaptcha;

public class FriendlyCaptchaResponse {

    private Boolean success;

    private String[] errors;

    public FriendlyCaptchaResponse(Boolean success, String[] errors) {
        this.success = success;
        this.errors = errors;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }
}
