package com.mateuszjanczak.cqrs.infrastructure.database.repository;

import com.mateuszjanczak.cqrs.infrastructure.database.entity.NoteEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class NoteRepository {

    private final Map<String, NoteEntity> noteEntityMap = new HashMap<>();

    public void save(NoteEntity noteEntity) {
        noteEntityMap.put(noteEntity.getId(), noteEntity);
    }

    public void update(String id, NoteEntity noteEntity) {
        noteEntityMap.replace(id, noteEntity);
    }

    public Optional<NoteEntity> findById(String id) {
        return noteEntityMap.values().stream().filter(noteEntity -> noteEntity.getId().equals(id)).findFirst();
    }
    public Optional<NoteEntity> findByCategory(String category) {
        return noteEntityMap.values().stream().filter(noteEntity -> noteEntity.getCategory().equals(category)).findFirst();
    }
}
