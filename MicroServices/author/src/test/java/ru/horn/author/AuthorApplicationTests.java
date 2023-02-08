package ru.horn.author;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:10-alpine:///auth",
        "spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver"})

class AuthorApplicationTests {

    @Test
    void contextLoads() {
    }

}
