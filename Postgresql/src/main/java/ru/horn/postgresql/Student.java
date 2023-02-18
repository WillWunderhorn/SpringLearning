package ru.horn.postgresql;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Period;

@Table(name = "students")
@Entity
@NoArgsConstructor
@Setter
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    int age;
    String email;
    LocalDate date_of_birth;

    public Student(String name, String email, LocalDate date_of_birth) {
        this.name = name;
        this.email = email;
        this.date_of_birth = date_of_birth;
    }

    public Student(String name, int age, String email, LocalDate date_of_birth) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.date_of_birth = date_of_birth;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return Period.between(this.date_of_birth, LocalDate.now()).getYears();
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDate(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
