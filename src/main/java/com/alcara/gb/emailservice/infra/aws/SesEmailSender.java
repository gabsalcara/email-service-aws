package com.alcara.gb.emailservice.infra.aws;

import com.alcara.gb.emailservice.adapters.EmailSenderGateway;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String para, String assunto, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("alcara.gb@gmail.com")
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
