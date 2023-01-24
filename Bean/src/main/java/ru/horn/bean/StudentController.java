package ru.horn.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    StudentRepository studentRepository;
    StudentService studentService;

    @Autowired
    public StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @PostMapping("/")
    public List<Student> addNewStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping(path = "{id}")
    public List<Student> deleteStudent(@PathVariable("id") Long id){
        return studentService.removeStudent(id);
    }

    @DeleteMapping(path = "/all")
    public List<Student> deleteStudent(){
        studentService.removeAllStudents();
        return studentService.findAll();
    }
}
