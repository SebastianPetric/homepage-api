package com.sebastian.homepage.api.domain.core.email;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class EmailContent {

    @NotEmpty
    @Email(message = "Email must be valid")
    private String email;

    private String optionalText;

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
}
