package com.sebastian.homepage.api.domain.core.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendEmail(String toEmail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setText("Bitte Lebenslauf an: ".concat(toEmail).concat(" verschicken."));
        simpleMailMessage.setSubject("Lebenslauf Anfrage");

        mailSender.send(simpleMailMessage);
    }
}
