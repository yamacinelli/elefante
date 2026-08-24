package com.elefante.backend.mail;

import java.io.IOException;

import jakarta.mail.MessagingException;

public interface MailService {
    void sendSetup(String... to) throws IOException, MessagingException;
    void sendWelcome(String... to) throws IOException, MessagingException;
}
