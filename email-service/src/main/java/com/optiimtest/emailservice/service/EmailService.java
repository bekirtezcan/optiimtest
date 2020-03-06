package com.optiimtest.emailservice.service;

import com.optiimtest.emailservice.model.Email;
import com.optiimtest.emailservice.repo.EmailRepository;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created By: Bekir Tezcan
 * Created At: 3.03.2020
 * Description :
 */
@Service
public class EmailService {

    private EmailRepository emailRepository;

    private Environment environment;

    private JavaMailSender javaMailSender;

    public EmailService(EmailRepository emailRepository, Environment environment, JavaMailSender javaMailSender) {
        this.emailRepository = emailRepository;
        this.environment = environment;
        this.javaMailSender = javaMailSender;
    }

    public Mono<Email> findById(String id) {
        return emailRepository.findById(id);
    }

    public Flux<Email> findAll() {
        return emailRepository.findAll();
    }

    public Mono<Email> create(Email Email) {
        return emailRepository.save(Email);
    }

    public Mono<Void> deleteAll() {
        return emailRepository.deleteAll();
    }

    public Mono<Void> deleteById(String id) {
        return emailRepository.deleteById(id);
    }

    public void sendEmail(Email mail){
        mail.setFromAddress(environment.getProperty("com.optiim.test.systemMail"));//it is redundant since SimpleMailMessage use mial account from properties
        this.create(mail);
        System.out.println("Email is sending... " + mail.toLogString());

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail.getToAddress());

        msg.setSubject(mail.getSubject());
        msg.setText(mail.getContent());
        msg.setFrom(mail.getFromAddress());

        javaMailSender.send(msg);
    }
}