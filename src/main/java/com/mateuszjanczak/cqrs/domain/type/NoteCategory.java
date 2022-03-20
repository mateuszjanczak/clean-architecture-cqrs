package com.mateuszjanczak.cqrs.domain.type;

public class NoteCategory {
    String noteCategory;

    public NoteCategory(String noteCategory) {
        this.noteCategory = noteCategory;
    }

    public String getNoteCategory() {
        return noteCategory;
    }
}
