package com.mateuszjanczak.cqrs.domain.model;

public class Note {
    String id;
    String text;
    String category;

    public Note(String id, String text, String category) {
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
