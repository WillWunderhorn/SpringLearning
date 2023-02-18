package ru.horn.javatests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DogConfigIntegrationTest {


    @Autowired
    private PetRepo petRepo;

    @Test
    public void darkTest() {
        String dark1 = petRepo.findPetsByName("Dark")
                .get().that_means;
        assertEquals(dark1, "He want to play");
    }

    @Test
    public void brownTest() {
        String brown1 = petRepo.findPetsByName("Brown")
                .get().that_means;
        assertEquals(brown1, "He want to eat");
    }

    @Test
    public void scrappyNutsTest() {
        String scrappyNuts1 = petRepo.findPetsByName("ScrappyNuts")
                .get().that_means;
        assertEquals(scrappyNuts1, "He want you to walk with him");
    }
}