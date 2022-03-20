package com.mateuszjanczak.cqrs.application.dto.request;

import com.mateuszjanczak.cqrs.domain.command.NoteCreateCommand;

public class NoteCreateDto {
    String text;
    String category;

    public NoteCreateDto(String text, String category) {
        this.text = text;
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public String getCategory() {
        return category;
    }

    public NoteCreateCommand noteCreateCommand() {
        return new NoteCreateCommand(this.text, this.category);
    }
}
