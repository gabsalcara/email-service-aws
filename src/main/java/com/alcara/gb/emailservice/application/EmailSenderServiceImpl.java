package com.alcara.gb.emailservice.application;

import com.alcara.gb.emailservice.adapters.EmailSenderGateway;
import com.alcara.gb.emailservice.core.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderServiceImpl(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void sendEmail(String para, String assunto, String body) {
        this.emailSenderGateway.sendEmail(para, assunto, body);
    }
}
