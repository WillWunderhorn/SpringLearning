package ru.horn.recursion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecursionApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecursionApplication.class, args);
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.fibonacci(5);
    }

}
