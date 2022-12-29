package ru.horn.springlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.horn.springlearning.jsonParse.JsonParser;
import ru.horn.springlearning.jsonParse.Root;
import ru.horn.springlearning.orm.Artists;
import ru.horn.springlearning.orm.Database;

@SpringBootApplication
public class SpringLearningApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringLearningApplication.class, args);

    }
}
