package com.mateuszjanczak.cqrs.application;

import com.mateuszjanczak.cqrs.application.dto.request.NoteCategoryUpdateDto;
import com.mateuszjanczak.cqrs.application.dto.request.NoteCreateDto;
import com.mateuszjanczak.cqrs.application.dto.request.NoteTextUpdateDto;
import com.mateuszjanczak.cqrs.domain.exception.NoteNotFoundException;
import com.mateuszjanczak.cqrs.domain.exception.TooLongTextException;
import com.mateuszjanczak.cqrs.domain.service.NoteCommandService;
import com.mateuszjanczak.cqrs.domain.type.NoteId;

public class NoteCommandController {

    private final NoteCommandService noteCommandService;

    public NoteCommandController(NoteCommandService noteCommandService) {
        this.noteCommandService = noteCommandService;
    }

    public void noteCreate(NoteCreateDto noteCreateDto) throws TooLongTextException {
        noteCommandService.create(noteCreateDto.noteCreateCommand());
    }

    public void noteTextUpdate(String id, NoteTextUpdateDto noteTextUpdateDto) throws NoteNotFoundException, TooLongTextException {
        noteCommandService.textUpdate(new NoteId(id), noteTextUpdateDto.noteTextUpdateCommand());
    }

    public void noteCategoryUpdate(String id, NoteCategoryUpdateDto noteCategoryUpdateDto) throws NoteNotFoundException {
        noteCommandService.categoryUpdate(new NoteId(id), noteCategoryUpdateDto.noteCategoryUpdateCommand());
    }
}
