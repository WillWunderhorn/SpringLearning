package ru.horn.kafka;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    String message;
    String type;
}
