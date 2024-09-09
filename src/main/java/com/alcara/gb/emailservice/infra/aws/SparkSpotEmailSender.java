package com.alcara.gb.emailservice.infra.aws;

import com.alcara.gb.emailservice.core.exceptions.EmailServiceException;
import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SparkSpotEmailSender {

    @Value("${SPARKPOST_API_KEY}")
    private String apiKey;

    public void sendEmail(String para, String assunto, String body) {

        Client client = new Client(apiKey);
        try {
            client.sendMessage(
                    para,
                    para,
                    assunto,
                    body,"");
        } catch (SparkPostException exception) {
            throw new EmailServiceException("Failure while sending email");
        }

    }
}
