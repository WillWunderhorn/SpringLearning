package ru.horn.buttonstest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class NumsController {
    StudentRepository studentRepository;

    @Autowired
    public NumsController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "/success")
    public String UploadPage(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "age") int age,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "date") LocalDate date,
            Model model
    ) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("email", email);
        model.addAttribute("date", date);
        Student student = new Student(name, age, email, date);
        studentRepository.save(student);
        return "success";
    }
}
