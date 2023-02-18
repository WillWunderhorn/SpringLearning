package ru.horn.book.service;

import book.BookDto;
import book.CreateBookDto;

public interface IBookService {
    BookDto createBook(Long authorId,
                       CreateBookDto createBookDto);
}
