package ru.horn.bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {


    @Bean
    CommandLineRunner commandLineRunner(StudentService studentService) {
        return args -> {
            Student robin =
                    new Student(
                    "Robin",
                    "robin@mail.com",
                    LocalDate.of(2003, MARCH, 4)
            );

            Student jenny = new Student(
                    "Jenny",
                    "janny@mail.com",
                    LocalDate.of(2000, JULY, 16)

            );

            Student thommy = new Student(
                    "Thommy",
                    "thommy@mail.com",
                    LocalDate.of(2013, DECEMBER, 26)
            );

            studentService.addNewStudent(robin);
            studentService.addNewStudent(jenny);
            studentService.addNewStudent(thommy);
        };
    }
}
