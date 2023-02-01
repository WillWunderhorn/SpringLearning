package ru.horn.webform;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Component
@Table(name = "students")
public class Student {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String email;
    private LocalDate date;

    public Student(String name, String email, LocalDate date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Student(String name, int age, String email, LocalDate date) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.date = date;
    }
}