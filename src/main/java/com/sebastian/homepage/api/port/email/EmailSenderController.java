package com.sebastian.homepage.api.port.email;

import com.sebastian.homepage.api.domain.core.email.EmailContent;
import com.sebastian.homepage.api.domain.core.email.EmailSenderService;
import com.sebastian.homepage.api.domain.core.exception.FriendlyCaptchaUnavailableException;
import com.sebastian.homepage.api.domain.core.exception.MailSendException;
import com.sebastian.homepage.api.domain.core.friendlycaptcha.FriendlyCaptchaResponse;
import com.sebastian.homepage.api.domain.core.friendlycaptcha.FriendlyCaptchaVerificationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    private final FriendlyCaptchaVerificationService friendlyCaptchaVerificationService;

    private final Logger logger = LoggerFactory.getLogger(EmailSenderController.class);

    public EmailSenderController(EmailSenderService emailSenderService, FriendlyCaptchaVerificationService friendlyCaptchaVerificationService) {
        this.emailSenderService = emailSenderService;
        this.friendlyCaptchaVerificationService = friendlyCaptchaVerificationService;
    }

    @PutMapping()
    public ResponseEntity<FriendlyCaptchaResponse> sendEmail(@RequestBody @Valid EmailContent emailContent) {

        FriendlyCaptchaResponse friendlyCaptchaResponse = friendlyCaptchaVerificationService.verify(emailContent.getSolution(), emailContent.getSiteKey());

        if (friendlyCaptchaResponse == null) {
            logger.warn("Friendly Captcha Service not reachable.");
            throw new FriendlyCaptchaUnavailableException();
        }


        if (!friendlyCaptchaResponse.getSuccess()) {
            logger.warn("Validation of friendly captcha failed.");
        }

        try {
            emailSenderService.sendEmail(emailContent.getEmail(), emailContent.getOptionalText());
        } catch (MailException e) {
            logger.warn("Mail couldn't be sent: ", e.fillInStackTrace());
            throw new MailSendException();
        }

        return ResponseEntity.ok(friendlyCaptchaResponse);
    }
}
