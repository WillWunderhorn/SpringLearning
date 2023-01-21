package ru.horn.autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class AutowiredApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutowiredApplication.class, args);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(PersonConfig.class);

        Person person = ctx.getBean("getPerson", Person.class);


        System.out.println(person);


    }
}
