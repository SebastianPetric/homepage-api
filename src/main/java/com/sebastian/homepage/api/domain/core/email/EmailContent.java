package com.sebastian.homepage.api.domain.core.email;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class EmailContent {

    @NotEmpty
    @Email(message = "Bitte geben Sie eine valide Email Adresse an.")
    private String email;

    private String optionalText;

    private String solution;

    private String siteKey;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOptionalText() {
        return optionalText;
    }

    public void setOptionalText(String optionalText) {
        this.optionalText = optionalText;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getSiteKey() {
        return siteKey;
    }

    public void setSiteKey(String siteKey) {
        this.siteKey = siteKey;
    }
}
