package ru.horn.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.horn.author.model.entity.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByName(String name);
    List<Author> findAllBySurname(String surname);
    List<Author> findAllBySurnameAndName(String surname, String name);
}
