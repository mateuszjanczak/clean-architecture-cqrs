package com.mateuszjanczak.cqrs.domain.type;

public class NoteId {
    String noteId;

    public NoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getNoteId() {
        return noteId;
    }
}
