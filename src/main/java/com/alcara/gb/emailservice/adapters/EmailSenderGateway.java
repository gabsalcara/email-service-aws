package com.alcara.gb.emailservice.adapters;

public interface EmailSenderGateway {

    void sendEmail(String para, String assunto, String body);
}
