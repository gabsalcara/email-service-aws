package com.alcara.gb.emailservice.core;

public interface EmailSenderUseCase {

    void sendEmail(String para, String assunto, String body);
}
