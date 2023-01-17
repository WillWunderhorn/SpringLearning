package ru.horn.postgresql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

import static java.util.Calendar.MARCH;

@Configuration
public class StudentConfig {
    private final StudentRepo studentRepo;

    public StudentConfig(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentService studentService){
        return args -> {
            Student maria = new Student(
                    "Maria",
                    "maria@mail.com",
                    LocalDate.of(2000, MARCH, 4)
            );
            studentRepo.save(maria);
        };
    }
}
