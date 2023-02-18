package ru.horn.author.controller;

import author.AuthorDto;
import author.CreateAuthorDto;
import author.UpdateAuthorDto;
import author.UpdateAuthorNameDto;
import book.CreateBookDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.horn.author.service.IAuthorService;

import java.util.List;

@RestController
@RequestMapping("/author")
@Log4j2
public class AuthorController {

    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDto createAuthor(@RequestBody CreateAuthorDto createAuthorDto) {
        log.info("Get request for author creation: author={}", createAuthorDto);

        AuthorDto authorDto = authorService.createAuthor(createAuthorDto);

        log.info("Return response for author creation: author={}", authorDto);

        return authorDto;
    }


    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDto createAuthorWithBook(@RequestPart("author") CreateAuthorDto createAuthorDto,
                                          @RequestPart("book") CreateBookDto createBookDto) {
        log.info("Get request for author creation: author={}", createAuthorDto);

        AuthorDto authorDto = authorService.createAuthorWithBook(createAuthorDto, createBookDto);

        log.info("Return response for author creation: author={}", authorDto);

        return authorDto;
    }


    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable Long id) {
        log.info("Get request for author by id: id={}", id);

        AuthorDto authorDto = authorService.getAuthorById(id);

        log.info("Return request for author by id: id={}, author={}", id, authorDto);

        return authorDto;
    }

    @GetMapping
    public Page<AuthorDto> getAuthorDtoList(Pageable pageable) {
        log.info("Get request for author list");

        Page<AuthorDto> authorDtoPage = authorService.getAuthorDtoList(pageable);

        log.info("Return request for author list: authorList={}", authorDtoPage);

        return authorDtoPage;
    }

    @GetMapping(params = {"name", "!surname"})
    public List<AuthorDto> getAuthorDtoListByName(@RequestParam @NotEmpty String name) {

        log.info("Get request for author by name: name={}", name);

        List<AuthorDto> authorDtoList = authorService.getAuthorDtoListByName(name);

        log.info("Return request for author by name: name={}, author={}", name, authorDtoList);

        return authorDtoList;
    }

    @GetMapping(params = {"surname", "!name"})
    public List<AuthorDto> getAuthorDtoListBySurName(@RequestParam @NotEmpty String surname) {
        log.info("Get request for author by surname: surname={}", surname);

        List<AuthorDto> authorDtoList = authorService.getAuthorDtoListBySurname(surname);

        log.info("Return request for author by surname: surname={}, author={}", surname, authorDtoList);

        return authorDtoList;
    }

    @GetMapping(params = {"name", "surname"})
    public List<AuthorDto> getAuthorDtoListByNameAndSurname(@RequestParam @NotEmpty String name,
                                                            @RequestParam @NotEmpty String surname) {
        log.info("Get request for author by surname: surname={}, name={}", surname, name);

        List<AuthorDto> authorDtoList = authorService.getAuthorDtoListByNameAndSurname(name, surname);

        log.info("Return request for author by surname: surname={}, name={}, author={}", surname, name, authorDtoList);

        return authorDtoList;
    }

    @PutMapping("/{id}")
    public AuthorDto updateAuthorDto(@PathVariable Long id,
                                     @RequestBody UpdateAuthorDto updateAuthorDto) {
        log.info("Get request for update author by id: id={}", id);

        AuthorDto authorDto = authorService.updateAuthorDto(id, updateAuthorDto);

        log.info("Return request for update author by id: id={}, author={}", id, authorDto);

        return authorDto;
    }

    @PatchMapping("/{id}")
    public AuthorDto updateAuthorName(@PathVariable Long id,
                                      @RequestBody UpdateAuthorNameDto updateAuthorNameDto) {
        log.info("Get request for update author name by id: id={}", id);

        AuthorDto authorDto = authorService.updateAuthorName(id, updateAuthorNameDto);

        log.info("Return request for update author name by id: id={}, author={}", id, authorDto);

        return authorDto;
    }

    @DeleteMapping("/{id}")
    public AuthorDto deleteAuthorDtoById(@PathVariable Long id) {
        log.info("Get request for delete author by id: id={}", id);

        AuthorDto authorDto = authorService.deleteAuthorDtoById(id);

        log.info("Return request for delete author by id: id={}, author={}", id, authorDto);

        return authorDto;
    }


}