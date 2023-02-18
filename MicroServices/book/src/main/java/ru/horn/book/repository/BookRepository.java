package ru.horn.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.horn.book.maodel.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
