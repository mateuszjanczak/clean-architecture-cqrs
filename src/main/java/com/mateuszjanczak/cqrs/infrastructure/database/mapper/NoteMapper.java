package com.mateuszjanczak.cqrs.infrastructure.database.mapper;

import com.mateuszjanczak.cqrs.domain.model.Note;
import com.mateuszjanczak.cqrs.infrastructure.database.entity.NoteEntity;

public class NoteMapper {

    public Note note(NoteEntity noteEntity) {
        return new Note(noteEntity.getId(), noteEntity.getText(), noteEntity.getCategory());
    }

    public NoteEntity noteEntity(Note note) {
        return new NoteEntity(note.getId(), note.getText(), note.getCategory());
    }
}
