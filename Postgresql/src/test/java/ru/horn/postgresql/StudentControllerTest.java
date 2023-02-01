package ru.horn.postgresql;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudentControllerTest {

    @Autowired
    StudentController studentController;
    StudentService studentService;
    StudentRepo studentRepo;


    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllStudents() {
        List<Student> list = studentController.getAllStudents();
        assertNotNull(list);
        System.out.println(list.size());
        System.out.println(list);
        assertNotEquals(0, list.size());
    }

//    @Test
//    void getAllStudentsFrom() {
//        List list2 = List.of(studentRepo.findAll());
//        assertNotNull(list2);
//        System.out.println(list2.size());
//        assertNotEquals(0, list2.size());
//    }

    @Test
    @Disabled
    void addNewStudent() {
    }
}