package ru.horn.transactional.Customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customers, Long> {

    @Query("SELECT c FROM Customers c where c.name = ?1")
    Optional<Customers> findCustomersByName(String name);
}
