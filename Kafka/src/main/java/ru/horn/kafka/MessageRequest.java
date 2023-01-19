package ru.horn.kafka;

import lombok.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    String message;
    String type;
}
