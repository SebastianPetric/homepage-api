package com.sebastian.homepage.api.config;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public class AudienceValidator implements OAuth2TokenValidator<Jwt> {

    private final String audience;

    AudienceValidator(String audience) {
        this.audience = audience;
    }


    @Override
    public OAuth2TokenValidatorResult validate(Jwt token) {
        List<String> audiences = token.getAudience();

        if (audiences.contains(this.audience))
            return OAuth2TokenValidatorResult.success();

        OAuth2Error oAuth2Error = new OAuth2Error(OAuth2ErrorCodes.INVALID_TOKEN);

        return OAuth2TokenValidatorResult.failure(oAuth2Error);
    }
}
