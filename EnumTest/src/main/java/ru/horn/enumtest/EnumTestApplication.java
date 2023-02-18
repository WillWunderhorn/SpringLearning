package ru.horn.enumtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class EnumTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnumTestApplication.class, args);

        TestEnum testEnum = TestEnum.of("GROUP_1");
        System.out.println(testEnum.name());

    }
}
