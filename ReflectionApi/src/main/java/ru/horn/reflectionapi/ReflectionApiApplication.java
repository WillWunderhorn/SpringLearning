package ru.horn.reflectionapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@SpringBootApplication
public class ReflectionApiApplication {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        SpringApplication.run(ReflectionApiApplication.class, args);

        Car car = new Car("E-type", 200000, 200);
        Car car2 = new Car("Y-type", 350000, 220);

//        Method[] carMethods = car.getClass().getDeclaredMethods();
//        Field[] carFields = car.getClass().getDeclaredFields();
//
//        for (Field fields : carFields){
//            if (fields.getName().equals("cost")) {
//                fields.setAccessible(true);
//                fields.set(car, 3000);
//            }
//        }
//
//        for (Method methods : carMethods) {
//            if (methods.getName().equals("getInfo")) {
//                methods.setAccessible(true);
//                methods.invoke(car);
//            }
//        }

        Method[] carMethods = car.getClass().getDeclaredMethods();
        Field[] carFields = car.getClass().getDeclaredFields();

        for (Field field : carFields){
            if (field.getName().equals("cost")){
                field.setAccessible(true);
                field.set(car2, 15000);
            }
        }

        for (Method method : carMethods){
            if (method.getName().equals("getInfo")) {
                method.setAccessible(true);
                method.invoke(car2);
            }
        }

    }
}
