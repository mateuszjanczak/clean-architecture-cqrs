package com.mateuszjanczak.cqrs.domain.query;

public class NoteCategoryQuery {
    String category;

    public NoteCategoryQuery(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
