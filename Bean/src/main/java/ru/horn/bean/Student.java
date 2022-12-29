package ru.horn.bean;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;


@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int age;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate date;

    public Student(String name, String email, LocalDate date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
