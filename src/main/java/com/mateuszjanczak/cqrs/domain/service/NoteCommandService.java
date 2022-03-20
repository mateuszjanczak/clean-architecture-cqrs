package com.mateuszjanczak.cqrs.domain.service;

import com.mateuszjanczak.cqrs.domain.command.NoteCategoryUpdateCommand;
import com.mateuszjanczak.cqrs.domain.command.NoteCreateCommand;
import com.mateuszjanczak.cqrs.domain.command.NoteTextUpdateCommand;
import com.mateuszjanczak.cqrs.domain.exception.NoteNotFoundException;
import com.mateuszjanczak.cqrs.domain.exception.TooLongTextException;
import com.mateuszjanczak.cqrs.domain.model.Note;
import com.mateuszjanczak.cqrs.domain.repository.NotePersistencePort;
import com.mateuszjanczak.cqrs.domain.type.NoteId;
import com.mateuszjanczak.cqrs.domain.validator.NoteValidator;

import java.util.UUID;

public class NoteCommandService {

    private final NoteValidator noteValidator;
    private final NotePersistencePort notePersistencePort;

    public NoteCommandService(NoteValidator noteValidator, NotePersistencePort notePersistencePort) {
        this.noteValidator = noteValidator;
        this.notePersistencePort = notePersistencePort;
    }

    public void create(NoteCreateCommand noteCreateCommand) throws TooLongTextException {
        noteValidator.validate(noteCreateCommand);
        notePersistencePort.save(new Note(UUID.randomUUID().toString(), noteCreateCommand.getText(), noteCreateCommand.getCategory()));
    }

    public void textUpdate(NoteId noteId, NoteTextUpdateCommand noteTextUpdateCommand) throws TooLongTextException, NoteNotFoundException {
        Note note = notePersistencePort.findById(noteId).orElseThrow(NoteNotFoundException::new);
        noteValidator.validate(noteTextUpdateCommand);
        notePersistencePort.update(noteId, new Note(note.getId(), noteTextUpdateCommand.getText(), note.getCategory()));
    }

    public void categoryUpdate(NoteId noteId, NoteCategoryUpdateCommand noteCategoryUpdateCommand) throws NoteNotFoundException {
        Note note = notePersistencePort.findById(noteId).orElseThrow(NoteNotFoundException::new);
        notePersistencePort.update(noteId, new Note(note.getId(), note.getText(), noteCategoryUpdateCommand.getCategory()));
    }
}
