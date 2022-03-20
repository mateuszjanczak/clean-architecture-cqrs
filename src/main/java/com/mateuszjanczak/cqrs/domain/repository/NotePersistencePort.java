package com.mateuszjanczak.cqrs.domain.repository;

import com.mateuszjanczak.cqrs.domain.model.Note;
import com.mateuszjanczak.cqrs.domain.type.NoteCategory;
import com.mateuszjanczak.cqrs.domain.type.NoteId;

import java.util.List;
import java.util.Optional;

public interface NotePersistencePort {
    void save(Note note);

    void update(NoteId noteId, Note note);

    Optional<Note> findById(NoteId noteId);

    List<Note> findByCategory(NoteCategory noteCategory);
}
