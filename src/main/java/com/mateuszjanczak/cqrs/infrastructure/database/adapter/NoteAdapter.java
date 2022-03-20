package com.mateuszjanczak.cqrs.infrastructure.database.adapter;

import com.mateuszjanczak.cqrs.domain.model.Note;
import com.mateuszjanczak.cqrs.domain.repository.NotePersistencePort;
import com.mateuszjanczak.cqrs.domain.type.NoteCategory;
import com.mateuszjanczak.cqrs.domain.type.NoteId;
import com.mateuszjanczak.cqrs.infrastructure.database.mapper.NoteMapper;
import com.mateuszjanczak.cqrs.infrastructure.database.repository.NoteRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NoteAdapter implements NotePersistencePort {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    public NoteAdapter(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    @Override
    public void save(Note note) {
        noteRepository.save(noteMapper.noteEntity(note));
    }

    @Override
    public void update(NoteId noteId, Note note) {
        noteRepository.update(noteId.getNoteId(), noteMapper.noteEntity(note));
    }

    @Override
    public Optional<Note> findById(NoteId noteId) {
        return noteRepository.findById(noteId.getNoteId()).map(noteMapper::note);
    }

    @Override
    public List<Note> findByCategory(NoteCategory noteCategory) {
        return noteRepository.findByCategory(noteCategory.getNoteCategory()).stream().map(noteMapper::note).collect(Collectors.toList());
    }
}
