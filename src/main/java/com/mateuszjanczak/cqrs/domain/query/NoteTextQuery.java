package com.mateuszjanczak.cqrs.domain.query;

public class NoteTextQuery {
    String text;

    public NoteTextQuery(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
