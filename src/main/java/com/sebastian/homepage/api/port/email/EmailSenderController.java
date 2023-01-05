package com.sebastian.homepage.api.port.email;

import com.sebastian.homepage.api.domain.core.email.EmailContent;
import com.sebastian.homepage.api.domain.core.email.EmailSenderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/send")
public class EmailSenderController {

    @Autowired
    private EmailSenderService emailSenderService;

    @PutMapping()
    public void sendEmail(@RequestBody @Valid EmailContent emailContent) {
        emailSenderService.sendEmail(emailContent.getEmail(), emailContent.getOptionalText());
    }
}
