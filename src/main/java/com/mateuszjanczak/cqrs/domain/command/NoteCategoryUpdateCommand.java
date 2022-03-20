package com.mateuszjanczak.cqrs.domain.command;

public class NoteCategoryUpdateCommand {
    String category;

    public NoteCategoryUpdateCommand(String text) {
        this.category = text;
    }

    public String getCategory() {
        return category;
    }
}
