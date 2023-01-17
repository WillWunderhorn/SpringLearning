package ru.horn.autowired;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dog implements Pet {
    String name;
    int age;

    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    @Override
    public void showName() {
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Pet's name: " + name + "\n" +
                "Age: " + age;
    }
}
