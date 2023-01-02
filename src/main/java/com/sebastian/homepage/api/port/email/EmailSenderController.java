package com.sebastian.homepage.api.port.email;

import com.sebastian.homepage.api.domain.core.email.EmailSenderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class EmailSenderController {

    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping("/{email}")
    public void sendEmail(@PathVariable @Valid String email) {
        emailSenderService.sendEmail(email);
    }
}
