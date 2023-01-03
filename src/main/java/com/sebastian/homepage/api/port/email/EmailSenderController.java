package com.sebastian.homepage.api.port.email;

import com.sebastian.homepage.api.domain.core.email.EmailSenderService;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/send")
public class EmailSenderController {

    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping("/{email}")
    public void sendEmail(@PathVariable @Email String email) {
        emailSenderService.sendEmail(email);
    }
}
