package com.mateuszjanczak.cqrs.domain.command;

public class NoteTextUpdateCommand {
    String text;

    public NoteTextUpdateCommand(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
