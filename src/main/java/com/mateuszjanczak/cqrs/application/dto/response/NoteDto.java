package com.mateuszjanczak.cqrs.application.dto.response;

import com.mateuszjanczak.cqrs.domain.query.NoteQuery;

public class NoteDto {
    String id;
    String text;
    String category;

    public NoteDto(String id, String text, String category) {
        this.id = id;
        this.text = text;
        this.category = category;
    }

    public NoteDto(NoteQuery noteQuery) {
        this.id = noteQuery.getId();
        this.text = noteQuery.getText();
        this.category = noteQuery.getCategory();
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getCategory() {
        return category;
    }
}
