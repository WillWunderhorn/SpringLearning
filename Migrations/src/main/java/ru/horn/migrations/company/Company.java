package ru.horn.migrations.company;

import ru.horn.migrations.person.Person;

import java.time.LocalDate;
import java.util.List;

public record Company(
        Long id,
        String name,
        List<Person> persons,
        LocalDate date) {
}
