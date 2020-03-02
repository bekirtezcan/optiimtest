package com.optiimtest.noteservice.service;

import com.optiimtest.noteservice.model.Note;
import com.optiimtest.noteservice.repo.INoteRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created By: Bekir Tezcan
 * Created At: 3.03.2020
 * Description :
 */
@Service
public class NoteService {

    private INoteRepository noteRepository;

    public NoteService(INoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Mono<Note> findById(String id){
        return noteRepository.findById(id);
    }

    public Flux<Note> findAll(){
        return noteRepository.findAll();
    }

    public Mono<Note> insert(Note note){
        return noteRepository.insert(note);
    }

    public Mono<Void> deleteAll(){
        return noteRepository.deleteAll();
    }

    public Mono<Void> deleteById(String id){
        return noteRepository.deleteById(id);
    }
/*
    Flux<Note> saveAll(List<Note> cities);
    Mono<Void> deleteAll();*/
}