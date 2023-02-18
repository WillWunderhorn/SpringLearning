package ru.horn.javatests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pets implements Sound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String that_means;

    public Pets(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String makeSound() {
        switch (this.getName()){
            case ("Dark"):
                that_means = "He want to play";
                break;
            case ("Brown"):
                that_means = "He want to eat";
                break;
            case ("ScrappyNuts"):
                that_means = "He want you to walk with him";
                break;
        }
        return that_means;
    }

    public String getThat_means() {
        return makeSound();
    }
}
