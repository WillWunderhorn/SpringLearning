package ru.horn.optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class OptionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(OptionalApplication.class, args);

        Optional<Obj> optionalObj = findObjectByType("Titanium");
        if (optionalObj.isPresent()){
            System.out.println(optionalObj.get().getName());
        } else {
            System.out.println("error");
        }


    }

    private static Optional<Obj> findObjectByType(String type) {
        Obj obj = new Obj(0, type);
        return Optional.ofNullable(obj);
    }

}
