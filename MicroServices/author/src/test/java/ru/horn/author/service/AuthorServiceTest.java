package ru.horn.author.service;

import author.AuthorDto;
import author.CreateAuthorDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.horn.author.model.entity.Author;
import ru.horn.author.provider.AuthProvider;
import ru.horn.author.repository.AuthorRepository;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    private AuthorRepository authorRepository1 = mock(AuthorRepository.class);

    @Test
    void createAuthor() {

        when(authorRepository.save(eq(AuthProvider.getAuthorForSave())))
                .thenReturn(AuthProvider.getAuthor());

        AuthorDto authorActual = authorService.createAuthor(AuthProvider.getCreateAuthorDto());

        assertEquals(AuthProvider.getAuthorDto(), authorActual);
    }

    @Test
    void getAuthorById() {
        when(authorRepository.findById(anyLong())).thenReturn(Optional.of(AuthProvider.getAuthor()));

        AuthorDto authorActual = authorService.getAuthorById(1L);

        assertEquals(AuthProvider.getAuthorDto(), authorActual);
    }

    @Test
    void contextLoad() {
    }

    @Test
    void getAuthorDtoList() {
    }

    @Test
    void getAuthorDtoListByName() {
    }

    @Test
    void getAuthorDtoListByNameAndSurname() {
    }

    @Test
    void updateAuthorDto() {
    }

    @Test
    void updateAuthorName() {
    }

    @Test
    void getAuthorDtoListBySurname() {
    }

    @Test
    void deleteAuthorDtoById() {
    }
}