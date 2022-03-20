package com.mateuszjanczak.cqrs.domain.service;

import com.mateuszjanczak.cqrs.domain.exception.NoteNotFoundException;
import com.mateuszjanczak.cqrs.domain.model.Note;
import com.mateuszjanczak.cqrs.domain.query.NoteCategoryQuery;
import com.mateuszjanczak.cqrs.domain.query.NoteQuery;
import com.mateuszjanczak.cqrs.domain.query.NoteTextQuery;
import com.mateuszjanczak.cqrs.domain.repository.NotePersistencePort;
import com.mateuszjanczak.cqrs.domain.type.NoteCategory;
import com.mateuszjanczak.cqrs.domain.type.NoteId;

import java.util.List;
import java.util.stream.Collectors;

public class NoteQueryService {

    private final NotePersistencePort notePersistencePort;

    public NoteQueryService(NotePersistencePort notePersistencePort) {
        this.notePersistencePort = notePersistencePort;
    }

    public NoteQuery getNoteById(NoteId noteId) throws NoteNotFoundException {
        Note note = notePersistencePort.findById(noteId).orElseThrow(NoteNotFoundException::new);
        return new NoteQuery(note.getId(), note.getText(), note.getCategory());
    }

    public NoteCategoryQuery getCategoryById(NoteId noteId) throws NoteNotFoundException {
        return new NoteCategoryQuery(notePersistencePort.findById(noteId).orElseThrow(NoteNotFoundException::new).getCategory());
    }

    public NoteTextQuery getTextById(NoteId noteId) throws NoteNotFoundException {
        return new NoteTextQuery(notePersistencePort.findById(noteId).orElseThrow(NoteNotFoundException::new).getText());
    }

    public List<NoteQuery> getNotesByCategory(NoteCategory noteCategory) {
        return notePersistencePort.findByCategory(noteCategory).stream().map(note -> new NoteQuery(note.getId(), note.getText(), note.getCategory())).collect(Collectors.toList());
    }
}
