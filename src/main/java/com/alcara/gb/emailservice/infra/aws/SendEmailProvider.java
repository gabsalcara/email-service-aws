package com.alcara.gb.emailservice.infra.aws;

import com.alcara.gb.emailservice.adapters.EmailSenderGateway;
import com.alcara.gb.emailservice.core.exceptions.EmailServiceException;
import org.springframework.stereotype.Service;

@Service
public class SendEmailProvider implements EmailSenderGateway {

    private SesEmailSender sesEmailSender;
    private SparkSpotEmailSender sparkSpotEmailSender;

    public SendEmailProvider(SesEmailSender sesEmailSender, SparkSpotEmailSender sparkSpotEmailSender){
        this.sesEmailSender = sesEmailSender;
        this.sparkSpotEmailSender = sparkSpotEmailSender;
    }

    @Override
    public void sendEmail(String para, String assunto, String body) {
        try {
            sesEmailSender.sendEmail(para, assunto, body);
        }  catch (EmailServiceException ex) {
            try {
                sparkSpotEmailSender.sendEmail(para,assunto,body);
            } catch (EmailServiceException exception) {
                throw new EmailServiceException("Nao foi possivel enviar o e-mail");
            }
        }


    }
}
