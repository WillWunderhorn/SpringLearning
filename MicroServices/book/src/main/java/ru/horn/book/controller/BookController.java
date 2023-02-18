package ru.horn.book.controller;

import book.BookDto;
import book.CreateBookDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.*;
import ru.horn.book.repository.BookRepository;
import ru.horn.book.service.IBookService;

@Log4j2
@RestController
@RequestMapping("/book")
public class BookController {

    private final IBookService bookService;
    private final BookRepository bookRepository;

    public BookController(IBookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public BookDto createBookDto(@RequestParam Long authorId,
                                 @RequestBody CreateBookDto createBookDto) {

        log.info("Get request for book creation: authorId={}, createBookDto={}", authorId, createBookDto);

        BookDto bookDto = bookService.createBook(authorId, createBookDto);

        log.info("Return response for book creation: authorId={}, createBookDto={}", authorId, createBookDto);

        return bookDto;
    }
}
