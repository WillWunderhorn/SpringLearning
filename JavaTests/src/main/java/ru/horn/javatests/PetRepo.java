package ru.horn.javatests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PetRepo extends JpaRepository<Pets, Long> {
    @Query("SELECT p from Pets p where p.name = ?1")
    Optional<Pets> findPetsByName(String name);
}
