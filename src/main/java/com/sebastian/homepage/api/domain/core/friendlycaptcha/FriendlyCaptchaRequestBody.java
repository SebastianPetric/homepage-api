package com.sebastian.homepage.api.domain.core.friendlycaptcha;

public class FriendlyCaptchaRequestBody {

    private String solution;

    private String secret;

    private String siteKey;

    public FriendlyCaptchaRequestBody(String solution, String secret, String siteKey) {
        this.solution = solution;
        this.secret = secret;
        this.siteKey = siteKey;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getSiteKey() {
        return siteKey;
    }

    public void setSiteKey(String siteKey) {
        this.siteKey = siteKey;
    }
}
