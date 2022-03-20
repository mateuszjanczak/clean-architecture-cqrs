package com.mateuszjanczak.cqrs.application;

import com.mateuszjanczak.cqrs.application.dto.response.NoteCategoryDto;
import com.mateuszjanczak.cqrs.application.dto.response.NoteDto;
import com.mateuszjanczak.cqrs.application.dto.response.NoteTextDto;
import com.mateuszjanczak.cqrs.domain.exception.NoteNotFoundException;
import com.mateuszjanczak.cqrs.domain.service.NoteQueryService;
import com.mateuszjanczak.cqrs.domain.type.NoteCategory;
import com.mateuszjanczak.cqrs.domain.type.NoteId;

import java.util.List;
import java.util.stream.Collectors;

public class NoteQueryController {

    private final NoteQueryService noteQueryService;

    public NoteQueryController(NoteQueryService noteQueryService) {
        this.noteQueryService = noteQueryService;
    }

    public NoteDto noteQuery(NoteId noteId) throws NoteNotFoundException {
        return new NoteDto(noteQueryService.getNoteById(noteId));
    }

    public NoteTextDto noteTextQuery(NoteId noteId) throws NoteNotFoundException {
        return new NoteTextDto(noteQueryService.getTextById(noteId));
    }

    public NoteCategoryDto noteCategoryQuery(NoteId noteId) throws NoteNotFoundException {
        return new NoteCategoryDto(noteQueryService.getCategoryById(noteId));
    }

    public List<NoteDto> noteQueryList(NoteCategory noteCategory) {
        return noteQueryService.getNotesByCategory(noteCategory).stream().map(NoteDto::new).collect(Collectors.toList());
    }
}
