package com.mateuszjanczak.cqrs.application.dto.response;

import com.mateuszjanczak.cqrs.domain.query.NoteCategoryQuery;

public class NoteCategoryDto {
    String category;

    public NoteCategoryDto(String category) {
        this.category = category;
    }

    public NoteCategoryDto(NoteCategoryQuery noteCategoryQuery) {
        this.category = noteCategoryQuery.getCategory();
    }

    public String getCategory() {
        return category;
    }
}
