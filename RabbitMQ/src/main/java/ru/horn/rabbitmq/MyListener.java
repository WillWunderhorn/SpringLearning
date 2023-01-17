package ru.horn.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class MyListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);

    @RabbitListener(queues = "queue")
    public void Queue(String message) {
        logger.info("From queue: {}", message);
    }

    @RabbitListener(queues = "warningQueue")
    public void processWarningQueue(String message) {
        logger.info("From warning queue: {}", message);
    }

    @RabbitListener(queues = "errorQueue")
    public void processErrorQueue(String message) {
        logger.info("From error queue: {}", message);
    }
}