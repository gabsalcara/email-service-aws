package com.alcara.gb.emailservice.infra.aws;

import com.alcara.gb.emailservice.core.exceptions.EmailServiceException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender {

    @Value("${EMAIL}")
    private String email;

    private AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    public void sendEmail(String para, String assunto, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource(email)
                .withDestination(new Destination().withToAddresses(para))
                .withMessage(new Message()
                        .withSubject(new Content(assunto))
                        .withBody(new Body().withText(new Content(body))));

        try {
            this.amazonSimpleEmailService.sendEmail(request);
        } catch (AmazonServiceException exception) {
            throw new EmailServiceException("Failure while sending email");
        }
    }
}
