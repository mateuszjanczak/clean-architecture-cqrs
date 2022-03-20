package com.mateuszjanczak.cqrs.application.dto.response;

import com.mateuszjanczak.cqrs.domain.query.NoteTextQuery;

public class NoteTextDto {
    String text;

    public NoteTextDto(String text) {
        this.text = text;
    }

    public NoteTextDto(NoteTextQuery noteTextQuery) {
        this.text = noteTextQuery.getText();
    }

    public String getText() {
        return text;
    }
}
