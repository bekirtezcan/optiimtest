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
@RequestMapping("/")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(value = "/{id}")
    public Mono<Note> getNote(@PathVariable("id") String id) {
        return noteService.findById(id);
    }

    @PostMapping("/")
    public Mono<Note> saveNote(@RequestBody Note note) {
        return noteService.create(note);
    }

    @PutMapping("/")
    public Mono<Note> editNote(@RequestBody Note note) {
        return noteService.update(note);
    }

    @GetMapping(value = "/list")
    public Flux<Note> getNotes() {
        return noteService.findAll();
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "note servis çalışıyor ama flux çalışmıyor";
        //return noteService.findAll();
    }
}
