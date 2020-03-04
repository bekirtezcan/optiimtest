package com.optiimtest.noteservice.service;

import com.optiimtest.noteservice.model.Email;
import com.optiimtest.noteservice.model.Note;
import com.optiimtest.noteservice.model.User;
import com.optiimtest.noteservice.mq.SendEmailMessageService;
import com.optiimtest.noteservice.repo.INoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created By: Bekir Tezcan
 * Created At: 3.03.2020
 * Description :
 */
@Service
public class NoteService {

    private INoteRepository noteRepository;

    private SendEmailMessageService sendEmailMessageService;

    private RestTemplate restTemplate;

    public NoteService(INoteRepository noteRepository, SendEmailMessageService sendEmailMessageService, RestTemplate restTemplate) {
        this.noteRepository = noteRepository;
        this.sendEmailMessageService = sendEmailMessageService;
        this.restTemplate = restTemplate;
    }

    public Mono<Note> findById(String id) {
        return noteRepository.findById(id);
    }

    public Flux<Note> findAll() {
        return noteRepository.findAll();
    }

    public Mono<Note> save(Note note) {
        Mono<Note> monoNote = noteRepository.save(note);
        monoNote.toFuture().thenAccept(savedNote -> sendEmailMessageService.sendEmail(createEmailFromNote(note)));
        //monoNote.doOnSuccess(savedNote -> sendEmailMessageService.sendEmail(createEmailFromNote(savedNote)));
        //sendEmailMessageService.sendEmail(createEmailFromNote(note));
        return monoNote;
    }

    public Mono<Void> deleteAll() {
        return noteRepository.deleteAll();
    }

    public Mono<Void> deleteById(String id) {
        return noteRepository.deleteById(id);
    }

    private Email createEmailFromNote(Note note) {
        User author = restTemplate.getForObject("http://user-service/user/" + note.getAuthorId(), User.class);

        Email mail = new Email().setSubject("\"" + note.getTitle() + "\" is created!")
                .setContent("New note is created by this user")
                .setToAddress(author.getMailAddress());

        return mail;
    }
}