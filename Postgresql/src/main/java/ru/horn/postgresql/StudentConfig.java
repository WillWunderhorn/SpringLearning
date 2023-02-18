package ru.horn.postgresql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.time.LocalDate;

import static java.util.Calendar.MARCH;

@Configuration
public class StudentConfig {
    private final StudentRepo studentRepo;
    private final JdbcTemplate jdbcTemplate;
    private final StudentService studentService;

    @Autowired
    public StudentConfig(StudentRepo studentRepo, JdbcTemplate jdbcTemplate, StudentService studentService) {
        this.studentRepo = studentRepo;
        this.jdbcTemplate = jdbcTemplate;
        this.studentService = studentService;
    }

//    @Bean
//    CommandLineRunner commandLineRunner() {
//        return args -> {
//            Student maria = new Student(
//                    "Maria",
//                    "maria@mail.com",
//                    LocalDate.of(2000, MARCH, 4)
//            );
//            maria.setAge(maria.getAge());
//            studentRepo.save(maria);
//        };
//    }

//    @Bean
//    public void autoTruncate() {
//        JdbcTestUtils.deleteFromTables(jdbcTemplate, "students");
//    }
}
