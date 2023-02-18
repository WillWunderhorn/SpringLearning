package ru.horn.book.controller.internal;

import book.BookDto;
import book.CreateBookDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import ru.horn.book.service.IBookService;

@Log4j2
@RestController
@RequestMapping("/internal/book")
public class InternalBookController {

    private final IBookService bookService;

    public InternalBookController(IBookService bookService) {
        this.bookService = bookService;
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
