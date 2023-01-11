package ru.horn.javatests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaTestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaTestsApplication.class, args);

        Bank fairBank = new Bank(5);
        Bank unFairBank = new Bank(20);

        Customer smartCustomer = new Customer(fairBank);
        Customer dingleBerryCustomer = new Customer(unFairBank);

        smartCustomer.askForCredit();
        dingleBerryCustomer.askForCredit();
    }

}
