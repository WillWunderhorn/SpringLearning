package ru.horn.author.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:tc:microservices:10-alpine:///auth",
        "spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver"})
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void findAllByName() {
    }

    @Test
    void findAllBySurname() {
    }

    @Test
    void findAllBySurnameAndName() {
    }
}