package com.optiimtest.emailservice.service;

import com.optiimtest.emailservice.model.Email;
import com.optiimtest.emailservice.repo.EmailRepository;
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

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public Mono<Email> findById(String id) {
        return emailRepository.findById(id);
    }

    public Flux<Email> findAll() {
        return emailRepository.findAll();
    }

    public Mono<Email> insert(Email Email) {
        return emailRepository.insert(Email);
    }

    public Mono<Void> deleteAll() {
        return emailRepository.deleteAll();
    }

    public Mono<Void> deleteById(String id) {
        return emailRepository.deleteById(id);
    }
/*
    Flux<Email> saveAll(List<Email> cities);
    Mono<Void> deleteAll();*/
}