package com.example.platform.async;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = "tweets_queue")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}
