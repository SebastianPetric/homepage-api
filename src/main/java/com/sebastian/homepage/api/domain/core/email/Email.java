package com.sebastian.homepage.api.domain.core.email;

import jakarta.validation.constraints.NotEmpty;

public class Email {

    @jakarta.validation.constraints.Email
    @NotEmpty
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

