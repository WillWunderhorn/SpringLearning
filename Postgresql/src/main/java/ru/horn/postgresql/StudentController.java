package ru.horn.postgresql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {
    private final StudentRepo studentRepo;
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentRepo studentRepo, StudentService studentService) {
        this.studentRepo = studentRepo;
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @PostMapping("/")
    public List<Student> addNewStudent(@RequestBody Student student) {
        studentService.addNew(student);
        return studentRepo.findAll();
    }

    @DeleteMapping(path = "{id}")
    public List<Student> removeStudent(
            @PathVariable("id") Long id
    ) {
        studentService.removeStudent(id);
        return studentRepo.findAll();
    }

    @DeleteMapping(path = "/")
    public List<Student> removeAllStudents() {
        studentService.clearStudentsList();
        return studentRepo.findAll();
    }

    @PutMapping(path = "{id}")
    public List<Student> changeStudent(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) LocalDate date
    ) {
        studentService.updateStudent(id, name, email, date);
        return studentRepo.findAll();
    }
}
