package ru.horn.author.controller;

import author.AuthorDto;
import author.CreateAuthorDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.horn.author.service.IAuthorService;

import java.util.List;

@RestController
@RequestMapping("/author")
@Log4j2
public class AuthorController {

    private IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public AuthorDto createAuthor(@RequestBody CreateAuthorDto createAuthorDto) {
        log.info("Get request for author creation: author={}", createAuthorDto);

        AuthorDto authorDto = authorService.createAuthor(createAuthorDto);

        log.info("Return response for author creation: author={}", createAuthorDto);

        return authorDto;
    }
}
