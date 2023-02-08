package ru.horn.author.controller;

import author.exception.AuthorExceptionDto;
import author.exception.ExceptionMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.horn.author.model.entity.exception.AuthorException;

@RestControllerAdvice
@Log4j2
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthorException.class)
    protected ResponseEntity<AuthorExceptionDto> handleAuthorException(AuthorException authorException) {
        log.error("Catch exception: ex={}", authorException);
        ExceptionMessage exceptionMessage = authorException.getExceptionMessage();

        AuthorExceptionDto authorExceptionDto = AuthorExceptionDto.builder()
                .exceptionMessage(exceptionMessage)
                .desc(exceptionMessage.getMessage())
                .build();

        ResponseEntity<AuthorExceptionDto> responseEntity = ResponseEntity
                .status(exceptionMessage.getHttpStatus())
                .body(authorExceptionDto);

        return responseEntity;
    }
}
