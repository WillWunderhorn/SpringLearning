package ru.horn.transactional.Customers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomersConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomersService customersService) {
        return args -> {
            Customers jack = new Customers(
                    "Jack",
                    10000
            );
            Customers thomas = new Customers(
                    "Thomas",
                    15000
            );
            customersService.addNewCustomer(jack);
            customersService.addNewCustomer(thomas);
        };
    }
}
