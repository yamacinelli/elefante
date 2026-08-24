package com.elefante.backend.mail;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MailServiceImpl implements MailService {

    protected final Log logger = LogFactory.getLog(getClass());

    private final JavaMailSender javaMailSender;

    @Value("${application.url.frontend}")
    private String urlFrontend;

    private String loadTemplate(String path) throws IOException {
        try (InputStream inputStream = new ClassPathResource(path).getInputStream()) {
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    @Override
    public void sendSetup(String... to) throws IOException, MessagingException {
        String template = loadTemplate("templates/mail/setup.html");
        String html = String.format(template, urlFrontend);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject("Confirm your email");
        mimeMessageHelper.setText(html, true);
        javaMailSender.send(mimeMessage);
    }

    @Override
    public void sendWelcome(String... to) throws IOException, MessagingException {
        String template = loadTemplate("templates/mail/welcome.html");
        String html = String.format(template, urlFrontend);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject("Welcome to the platform");
        mimeMessageHelper.setText(html, true);
        javaMailSender.send(mimeMessage);
    }
}
