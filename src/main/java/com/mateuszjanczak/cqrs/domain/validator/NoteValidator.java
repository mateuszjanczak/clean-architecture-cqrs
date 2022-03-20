package com.mateuszjanczak.cqrs.domain.validator;

import com.mateuszjanczak.cqrs.domain.command.NoteCreateCommand;
import com.mateuszjanczak.cqrs.domain.command.NoteTextUpdateCommand;
import com.mateuszjanczak.cqrs.domain.exception.TooLongTextException;

public class NoteValidator {

    public void validate(NoteCreateCommand noteCreateCommand) throws TooLongTextException {
        if(noteCreateCommand.getText().length() > 64) throw new TooLongTextException();
    }

    public void validate(NoteTextUpdateCommand noteTextUpdateCommand) throws TooLongTextException {
        if(noteTextUpdateCommand.getText().length() > 64) throw new TooLongTextException();
    }
}
