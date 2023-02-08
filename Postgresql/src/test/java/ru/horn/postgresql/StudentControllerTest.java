package ru.horn.postgresql;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static java.util.Calendar.FEBRUARY;
import static java.util.Calendar.MARCH;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudentControllerTest {

    @Autowired
    StudentController studentController;
    StudentService studentService;
    StudentRepo studentRepo;

    @Autowired
    public StudentControllerTest(StudentController studentController, StudentService studentService, StudentRepo studentRepo) {
        this.studentController = studentController;
        this.studentService = studentService;
        this.studentRepo = studentRepo;
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetAllStudents() {
        List<Student> list = studentController.getAllStudents();
        assertNotNull(list);
        System.out.println(list.size());
        System.out.println(list);
        assertNotEquals(0, list.size());
    }

    @Test
    void testAddNewStudent() {
        Student student = new Student(
                "Maria2",
                "maria@mail2.com",
                LocalDate.of(2001, MARCH, 4)
        );
        student.setAge(student.getAge());
        studentRepo.save(student);

        System.out.println(studentRepo.findAll());

        assertTrue(studentRepo.findAll().contains(student));
    }

    @Test
    public void testAddNew_EmailTaken() {
        Student student2 = new Student(
                "Maria",
                "maria@mail.com",
                LocalDate.of(2015, FEBRUARY, 24)
        );
        student2.setAge(student2.getAge());
        studentService.addNew(student2);
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> studentService.addNew(student2));
        assertEquals("EMAIL IS TAKEN!", exception.getMessage());
    }

    @Test
    public void testAddNew() {
        Student student = new Student(
                "Maria2",
                "maria@mail2.com",
                LocalDate.of(2001, MARCH, 4)
        );
        student.setAge(student.getAge());
        studentRepo.save(student);
        studentRepo.save(student);

        assertThatThrownBy(() -> studentService.addNew(student))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("EMAIL IS TAKEN!");
    }

}