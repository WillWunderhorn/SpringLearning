package ru.horn.bean;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "students")
@Setter
@NoArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int age;
    String email;
    LocalDate date;

    public Student(String name, String email, LocalDate date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAge() {
        return Period.between(this.date, LocalDate.now()).getYears();
    }
}
