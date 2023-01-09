package com.sebastian.homepage.api.domain.core.friendlycaptcha;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class FriendlyCaptchaVerificationService {


    private final RestTemplate restTemplate;

    @Value("${friendly-captcha.verification-url}")
    private String verificationUrl;

    @Value("${friendly-captcha.api-key}")
    private String apiKey;

    public FriendlyCaptchaVerificationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public FriendlyCaptchaResponse verify(String solution, String siteKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        FriendlyCaptchaRequestBody body = new FriendlyCaptchaRequestBody(solution, apiKey, siteKey);

        HttpEntity<FriendlyCaptchaRequestBody> entity = new HttpEntity<>(body, headers);
        return this.restTemplate.postForObject(verificationUrl, entity, FriendlyCaptchaResponse.class);
    }

}
