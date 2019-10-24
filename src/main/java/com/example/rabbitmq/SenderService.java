package com.example.rabbitmq;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderService {
    @Autowired
    TopicExchange demoTopic;

    @Autowired
    FanoutExchange fanoutDemoActive;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendPayloadToRabbit(String payload){
        rabbitTemplate.convertAndSend(demoTopic.getName(), Producer.DEMO_ROUTE, payload);
    }
}
