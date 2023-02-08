package ru.horn.author.util;

import author.AuthorDto;
import author.CreateAuthorDto;
import author.UpdateAuthorDto;
import author.UpdateAuthorNameDto;
import ru.horn.author.model.entity.Author;

public class AuthorUtil {

    public static AuthorDto getAuthorDto(Author author) {
        AuthorDto authorDto = AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .build();
        return authorDto;
    }

    public static Author getAuthor(CreateAuthorDto createAuthorDto) {
        Author createAuthor = Author.builder()
                .name(createAuthorDto.getName())
                .surname(createAuthorDto.getSurname())
                .build();

        return createAuthor;
    }

    public static Author getAuthor(Author author,
                                   UpdateAuthorDto updateAuthorDto) {
        Author updatedAuthor = author.toBuilder()
                .name(updateAuthorDto.getName())
                .surname(updateAuthorDto.getSurname())
                .build();

        return updatedAuthor;
    }

    public static Author getAuthor(Author author,
                                   UpdateAuthorNameDto updateAuthorNameDto) {
        Author updatedAuthor = author.toBuilder()
                .name(updateAuthorNameDto.getName())
                .build();

        return updatedAuthor;
    }
}
