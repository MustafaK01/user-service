package com.mustafak01.userservice.service.impl;

import com.mustafak01.userservice.consts.Constants;
import com.mustafak01.userservice.service.EmailService;
import com.mustafak01.userservice.utils.EmailUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    @Value("${verify.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String fromEmail;
    private final JavaMailSender emailSender;

    @Override
    @Async
    public void sendSimpleEmailMessage(String name, String to, String confirmationKey) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject(Constants.NEW_USER_ACCOUNT_VERIFICATION);
            simpleMailMessage.setFrom(fromEmail);
            simpleMailMessage.setTo(to);
            simpleMailMessage.setText(EmailUtils.getEmailMessage(name,host,confirmationKey));
            emailSender.send(simpleMailMessage);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Async
    public void sendMimeMessageWithAttachments(String name, String to, String confirmationKey) {
        try {

        }catch (Exception e){

        }
    }

    @Override
    @Async
    public void sendMimeMessageWithEmbeddedImages(String name, String to, String confirmationKey) {
        try {

        }catch (Exception e){

        }
    }

    @Override
    @Async
    public void sendMimeMessageWithEmbeddedFiles(String name, String to, String confirmationKey) {
        try {

        }catch (Exception e){

        }
    }

    @Override
    @Async
    public void sendHtmlEmail(String name, String to, String confirmationKey) {
        try {

        }catch (Exception e){

        }
    }

    @Override
    @Async
    public void sendHtmlEmailWithEmbeddedFiles(String name, String to, String confirmationKey) {
        try {

        }catch (Exception e){

        }
    }
}
