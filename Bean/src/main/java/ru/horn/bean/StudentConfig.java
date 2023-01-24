package ru.horn.bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {
    private final StudentRepository studentRepository;

    public StudentConfig(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Bean
    CommandLineRunner commandLineRunner(StudentService studentService) {
        return args -> {
            Student maria = new Student(
                    "Maria",
                    "maria@mail.com",
                    LocalDate.of(2003, Month.MARCH, 6)
            );
            Student thomas = new Student(
                    "Thomas",
                    "thomas@mail.com",
                    LocalDate.of(2000, Month.FEBRUARY, 24)
            );
            studentRepository.save(maria);
            studentRepository.save(thomas);
        };
    }
}
