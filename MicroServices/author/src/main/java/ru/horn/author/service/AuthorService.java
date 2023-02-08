package ru.horn.author.service;

import author.AuthorDto;
import author.CreateAuthorDto;
import author.UpdateAuthorDto;
import author.exception.ExceptionMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.horn.author.model.entity.Author;
import ru.horn.author.model.entity.exception.AuthorException;
import ru.horn.author.repository.AuthorRepository;
import ru.horn.author.util.AuthorUtil;

import java.util.List;
import java.util.stream.Collectors;

import static ru.horn.author.util.AuthorUtil.getAuthor;
import static ru.horn.author.util.AuthorUtil.getAuthorDto;

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

    @Override
    public AuthorDto getAuthorById(Long id) {

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorException(ExceptionMessage.AUTHOR_NOT_FOUND));
        AuthorDto authorDto = getAuthorDto(author);
        return authorDto;
    }

    @Override
    public Page<AuthorDto> getAuthorDtoList(Pageable pageable) {

        Page<Author> authorPage = authorRepository.findAll(pageable);
        Page<AuthorDto> authorDtoPage = authorPage.map(AuthorUtil::getAuthorDto);
        return authorDtoPage;
    }

    @Override
    public List<AuthorDto> getAuthorDtoListByName(String name) {

        List<Author> authorList = authorRepository.findAllByName(name);
        List<AuthorDto> authorDtoList = authorList.stream().map(AuthorUtil::getAuthorDto).toList();
        return authorDtoList;
    }

    @Override
    public List<AuthorDto> getAuthorDtoListByNameAndSurname(String name, String surname) {

        List<Author> authorList = authorRepository.findAllBySurnameAndName(surname, name);

        List<AuthorDto> authorDtoList = authorList.stream()
                .map(AuthorUtil::getAuthorDto)
                .toList();

        return authorDtoList;
    }

    @Override
    public AuthorDto updateAuthorDto(Long id,
                                     UpdateAuthorDto updateAuthorDto) {

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorException(ExceptionMessage.AUTHOR_NOT_FOUND));

        Author authorForUpdate = getAuthor(author, updateAuthorDto);

        authorForUpdate = authorRepository.save(authorForUpdate);

        AuthorDto authorDto = getAuthorDto(authorForUpdate);

        return authorDto;
    }

    @Override
    public AuthorDto updateAuthorName(Long id,
                                      UpdateAuthorDto updateAuthorNameDto) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorException(ExceptionMessage.AUTHOR_NOT_FOUND));

        Author authorForUpdate = AuthorUtil.getAuthor(author, updateAuthorNameDto);

        authorForUpdate = authorRepository.save(authorForUpdate);

        AuthorDto authorDto = getAuthorDto(authorForUpdate);

        return authorDto;
    }

    @Override
    public List<AuthorDto> getAuthorDtoListBySurname(String surname) {

        List<Author> authorList = authorRepository.findAllBySurname(surname);
        List<AuthorDto> authorDtoList = authorList.stream()
                .map(AuthorUtil::getAuthorDto)
                .toList();
        return authorDtoList;
    }

    @Override
    @Transactional
    public AuthorDto deleteAuthorDtoById(Long id) {

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorException(ExceptionMessage.AUTHOR_NOT_FOUND));

        authorRepository.delete(author);

        AuthorDto authorDto = getAuthorDto(author);

        return authorDto;
    }
}
