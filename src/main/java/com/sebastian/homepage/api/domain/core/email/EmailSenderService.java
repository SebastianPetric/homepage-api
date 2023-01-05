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

    @Value("${email.to}")
    private String to;

    public void sendEmail(String RequesterEmail, String optionalText) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText("Bitte Lebenslauf an: ".concat(RequesterEmail).concat(" verschicken. \n\n").concat("Optionale Nachricht: \n\n").concat(optionalText));
        simpleMailMessage.setSubject("Lebenslauf Anfrage");

        mailSender.send(simpleMailMessage);
    }
}
