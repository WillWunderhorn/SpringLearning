package ru.horn.book.service;

import book.BookDto;
import book.CreateBookDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.horn.book.maodel.entity.Book;
import ru.horn.book.repository.BookRepository;
import ru.horn.book.util.BookUtil;

@Service
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public BookDto createBook(Long authorId,
                              CreateBookDto createBookDto) {

        Book book = BookUtil.createBook(authorId, createBookDto);

        Book createdBook = bookRepository.save(book);

        BookDto bookDto = BookUtil.createBookDto(createdBook);

        return bookDto;
    }
}
