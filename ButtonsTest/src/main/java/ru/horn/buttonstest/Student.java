package ru.horn.buttonstest;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int age;
    String email;
    LocalDate date;

    public Student(String name, int age, String email, LocalDate date) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.date = date;
    }
}
