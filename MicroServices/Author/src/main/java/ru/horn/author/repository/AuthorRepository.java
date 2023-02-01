package ru.horn.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.horn.author.model.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
