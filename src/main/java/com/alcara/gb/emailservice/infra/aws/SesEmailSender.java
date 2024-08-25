package com.alcara.gb.emailservice.infra.aws;

import com.alcara.gb.emailservice.adapters.EmailSenderGateway;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;

public class SesEmailSender implements EmailSenderGateway {

    private AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String para, String assunto, String body) {

    }
}
