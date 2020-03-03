package com.optiimtest.noteservice.controller;

import com.optiimtest.noteservice.model.Note;
import com.optiimtest.noteservice.service.NoteService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created By: Bekir Tezcan
 * Created At: 3.03.2020
 * Description :
 */
@RestController
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(value = "/note/{id}")
    public Mono<Note> getNote(@PathVariable("id") String id) {
        return noteService.findById(id);
    }

    @PostMapping(value = "/note")
    public Mono<Note> saveNote(@RequestBody Note note) {
        return noteService.save(note);
    }

    @PutMapping(value = "/note")
    public Mono<Note> editNote(@RequestBody Note note) {
        return noteService.save(note);
    }

    @GetMapping(value = "/notes")
    public Flux<Note> getNotes() {
        return noteService.findAll();
    }
}
