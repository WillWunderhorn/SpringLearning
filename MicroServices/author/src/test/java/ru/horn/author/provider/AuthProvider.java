package ru.horn.author.provider;

import author.AuthorDto;
import author.CreateAuthorDto;
import ru.horn.author.model.entity.Author;

public class AuthProvider {

    public static CreateAuthorDto getCreateAuthorDto() {
        CreateAuthorDto createAuthorDto = CreateAuthorDto.builder()
                .name("name")
                .surname("surname")
                .build();
        return createAuthorDto;
    }

    public static Author getAuthorForSave() {
        Author authorForSave = Author.builder()
                .name("name")
                .surname("surname")
                .build();

        return authorForSave;
    }

    public static Author getAuthor() {
        Author author = Author.builder()
                .id(1L)
                .name("name")
                .surname("surname")
                .build();
        return author;
    }

    public static AuthorDto getAuthorDto() {
        return AuthorDto.builder()
                .id(1L)
                .name("name")
                .surname("surname")
                .build();
    }
}
