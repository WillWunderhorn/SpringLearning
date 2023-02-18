package ru.horn.author.service;

import author.AuthorDto;
import author.CreateAuthorDto;
import author.UpdateAuthorDto;
import author.UpdateAuthorNameDto;
import book.CreateBookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAuthorService {
    AuthorDto createAuthor(CreateAuthorDto createAuthorDto);

    AuthorDto getAuthorById(Long id);

    Page<AuthorDto> getAuthorDtoList(Pageable pageable);

    List<AuthorDto> getAuthorDtoListByName(String name);

    List<AuthorDto> getAuthorDtoListBySurname(String surname);

    List<AuthorDto> getAuthorDtoListByNameAndSurname(String name,
                                                     String surname);

    AuthorDto updateAuthorDto(Long id,
                              UpdateAuthorDto updateAuthorDto);

    AuthorDto updateAuthorName(Long id,
                               UpdateAuthorNameDto updateAuthorNameDto);

    AuthorDto deleteAuthorDtoById(Long id);

    AuthorDto createAuthorWithBook(CreateAuthorDto createAuthorDto,
                                   CreateBookDto createBookDto);
}