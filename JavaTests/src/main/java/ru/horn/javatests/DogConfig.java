package ru.horn.javatests;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DogConfig {
    public final PetRepo petRepo;

    public DogConfig(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Pets dark = new Pets("Dark");
            dark.makeSound();

            Pets brown = new Pets("Brown");
            brown.makeSound();

            Pets scrappyNuts = new Pets("ScrappyNuts");
            scrappyNuts.makeSound();

            petRepo.deleteAll();

            petRepo.save(dark);
            petRepo.save(brown);
            petRepo.save(scrappyNuts);
        };
    }
}
