package ru.horn.author.provider;

import author.AuthorDto;
import author.CreateAuthorDto;
import ru.horn.author.model.entity.Author;

public class AuthProvider {

    public static final Long USER_ID = 2L;

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
                .id(USER_ID)
                .name("name")
                .surname("surname")
                .build();
        return author;
    }

    public static AuthorDto getAuthorDto() {
        return AuthorDto.builder()
                .id(USER_ID)
                .name("name")
                .surname("surname")
                .build();
    }
}
