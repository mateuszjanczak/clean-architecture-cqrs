package com.mateuszjanczak.cqrs.domain.command;

public class NoteCreateCommand {
    String text;
    String category;

    public NoteCreateCommand(String text, String category) {
        this.text = text;
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public String getCategory() {
        return category;
    }
}
