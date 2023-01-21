package ru.horn.autowired;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    String name;

    @Qualifier("getDog")
    @Autowired
    Pet pet;

    @Override
    public String toString() {
        return  "Name: " + name + "\n" +
                "Pet: " + pet;
    }
}
