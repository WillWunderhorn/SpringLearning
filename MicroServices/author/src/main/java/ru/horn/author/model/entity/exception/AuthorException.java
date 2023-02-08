package ru.horn.author.model.entity.exception;

import author.exception.ExceptionMessage;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class AuthorException extends RuntimeException {
    private ExceptionMessage exceptionMessage;

    public AuthorException(ExceptionMessage exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
