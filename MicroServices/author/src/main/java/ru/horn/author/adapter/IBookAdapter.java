package ru.horn.author.adapter;

import book.BookDto;
import book.CreateBookDto;

public interface IBookAdapter {
    BookDto createBook(Long id, CreateBookDto createBookDto);
}
