package ru.horn.reflectionapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Car {
    private final String type;
    private final int cost;
    private final int speed;

    private void getInfo(){
        System.out.println("CAR REPRESENTATION: \n" +
                getType() + "\n" + getCost());
    }
}
