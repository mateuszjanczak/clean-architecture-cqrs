package com.mateuszjanczak.cqrs.application.dto.request;

import com.mateuszjanczak.cqrs.domain.command.NoteTextUpdateCommand;

public class NoteTextUpdateDto {
    String text;

    public NoteTextUpdateDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public NoteTextUpdateCommand noteTextUpdateCommand() {
        return new NoteTextUpdateCommand(this.text);
    }
}
