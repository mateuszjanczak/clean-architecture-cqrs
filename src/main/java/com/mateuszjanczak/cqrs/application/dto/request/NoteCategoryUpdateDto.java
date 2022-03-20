package com.mateuszjanczak.cqrs.application.dto.request;

import com.mateuszjanczak.cqrs.domain.command.NoteCategoryUpdateCommand;

public class NoteCategoryUpdateDto {
    String category;

    public NoteCategoryUpdateDto(String text) {
        this.category = text;
    }

    public String getCategory() {
        return category;
    }

    public NoteCategoryUpdateCommand noteCategoryUpdateCommand() {
        return new NoteCategoryUpdateCommand(this.category);
    }
}
