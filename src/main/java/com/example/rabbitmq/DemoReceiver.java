package com.example.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class DemoReceiver {

    @RabbitHandler
    @RabbitListener(queues = "#{demoQueue.name}")
    public void receiveDemoPayload(String payload) {
        System.out.println("receive payload -> " + payload);
    }
}
