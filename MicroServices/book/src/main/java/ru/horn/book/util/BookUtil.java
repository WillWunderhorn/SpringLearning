package ru.horn.book.util;

import book.BookDto;
import book.CreateBookDto;
import ru.horn.book.maodel.entity.Book;


public class BookUtil {
    public static Book createBook(Long authorId,
                                  CreateBookDto createBookDto) {
        Book build = Book.builder()
                .authorId(authorId)
                .name(createBookDto.getName())
//                .desc(createBookDto.getDesc())
                .price(createBookDto.getPrice())
                .issueDate(createBookDto.getIssueDate())
                .build();
        return build;
    }

    public static BookDto createBookDto(Book book) {
        BookDto bookDto = BookDto.builder()
                .id(book.getId())
                .name(book.getName())
//                .desc(book.getDesc())
                .price(book.getPrice())
                .issueDate(book.getIssueDate())
                .build();

        return bookDto;
    }
}
