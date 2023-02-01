package ru.horn.author.service;

import author.AuthorDto;
import author.CreateAuthorDto;

public interface IAuthorService {
    AuthorDto createAuthor(CreateAuthorDto createAuthorDto);
}
