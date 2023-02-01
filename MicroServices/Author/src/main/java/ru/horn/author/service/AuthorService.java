package ru.horn.author.service;

import author.AuthorDto;
import author.CreateAuthorDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.horn.author.model.entity.Author;
import ru.horn.author.repository.AuthorRepository;

@Service
public class AuthorService implements IAuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto createAuthor(CreateAuthorDto createAuthorDto) {

        Author createAuthor = getAuthor(createAuthorDto);

        Author author = authorRepository.save(createAuthor);

        AuthorDto authorDto = getAuthorDto(author);

        return authorDto;
    }

    private AuthorDto getAuthorDto(Author author) {
        AuthorDto authorDto = AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .build();
        return authorDto;
    }

    private Author getAuthor(CreateAuthorDto createAuthorDto) {
        Author createAuthor = Author.builder()
                .name(createAuthorDto.getName())
                .surname(createAuthorDto.getSurname())
                .build();

        return createAuthor;
    }
}
