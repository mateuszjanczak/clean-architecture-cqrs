package com.mateuszjanczak.cqrs.infrastructure.database.entity;

public class NoteEntity {
    String id;
    String text;
    String category;

    public NoteEntity(String id, String text, String category) {
        this.id = id;
        this.text = text;
        this.category = category;
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
