package ru.horn.webform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.Period;


@Controller
public class StudentController {
    StudentRepo studentRepo;
    Student student;

    public StudentController(StudentRepo studentRepo, Student student) {
        this.studentRepo = studentRepo;
        this.student = student;
    }

    @RequestMapping("/index")
    public String loadMainPage() {
        return "index";
    }

    @RequestMapping("/success")
    public String loadSuccessPage(

            @RequestParam(name = "name") String name,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "date") LocalDate date,
            Model model
    ) {
        model.addAttribute("name", name);
        int age = Period.between(date, LocalDate.now()).getYears();
        model.addAttribute("age", age);
        model.addAttribute("email", email);
        model.addAttribute("date", date);
        Student student = new Student(name, age, email, date);
        studentRepo.save(student);
        return "success";
    }
}
