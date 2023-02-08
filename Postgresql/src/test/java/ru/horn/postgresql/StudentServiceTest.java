package ru.horn.postgresql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    StudentRepo studentRepo;
    StudentService studentService;

    @Autowired
    public StudentServiceTest(StudentRepo studentRepo, StudentService studentService) {
        this.studentRepo = studentRepo;
        this.studentService = studentService;
    }

    @Test
    void findAll() {

    }

    @Test
    void addNew() {
    }

    @Test
    void removeStudent() {
    }

    @Test
    void clearStudentsList() {
    }

    @Test
    void updateStudent() {
    }
}