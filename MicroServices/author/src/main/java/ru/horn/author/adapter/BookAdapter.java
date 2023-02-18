package ru.horn.author.adapter;

import book.BookDto;
import book.CreateBookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class BookAdapter implements IBookAdapter {

    private final RestTemplate restTemplate;

    public BookAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public BookDto createBook(Long authorId,
                              CreateBookDto createBookDto) {

        UriComponents bookService = UriComponentsBuilder
                .fromHttpUrl("http://book//internal/book")
                .queryParam("authorId", authorId)
                .build();

        ResponseEntity<BookDto> bookDtoResponseEntity = restTemplate.postForEntity(bookService.toUriString(), createBookDto, BookDto.class);

        BookDto bookDto = bookDtoResponseEntity.getBody();

        return bookDto;
    }
}
