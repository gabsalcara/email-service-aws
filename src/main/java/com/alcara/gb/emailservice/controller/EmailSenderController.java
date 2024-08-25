package com.alcara.gb.emailservice.controller;

import com.alcara.gb.emailservice.adapters.EmailSenderGateway;
import com.alcara.gb.emailservice.application.EmailSenderService;
import com.alcara.gb.emailservice.core.Dto.EmailRequest;
import com.alcara.gb.emailservice.core.exceptions.EmailServiceException;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/email")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;

    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        try {
            emailSenderService.sendEmail(request.para(), request.assunto(), request.body());
            return ResponseEntity.ok().body("email send successfully");
        } catch (EmailServiceException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
        }
    }
}
