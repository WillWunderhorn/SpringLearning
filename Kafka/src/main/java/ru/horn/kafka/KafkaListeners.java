package ru.horn.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "horn",
            groupId = "groupId"
    )

//    void listener(String data) {
//        if(data instanceof String){
//            System.out.println(data + " :String");
//        }
//        System.out.println("Data:" + data);
//    }

    void listener1(String message, String type) {
        System.out.println("Message: " + message + "\nType: " + type);
        System.out.println("Type of data:" + message.getClass().getName());
    }
}
