package com.optiimtest.noteservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created By: Bekir Tezcan
 * Created At: 3.03.2020
 * Description :
 */
@Document
public class Note {
    @Id
    private String noteId;

    private String authorId;//user

    private String title;

    private String content;

    public String getNoteId() {
        return noteId;
    }

    public Note setNoteId(String noteId) {
        this.noteId = noteId;
        return this;
    }

    public String getAuthorId() {
        return authorId;
    }

    public Note setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Note setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Note setContent(String content) {
        this.content = content;
        return this;
    }
}
