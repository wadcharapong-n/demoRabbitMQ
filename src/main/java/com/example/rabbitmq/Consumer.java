package com.example.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Consumer {

    @Bean
    public Queue demoQueue() {
        return new Queue("demo.route.queue");
    }

    @Bean
    public Binding bindingDemo(TopicExchange demoTopic, Queue demoQueue) {
        return BindingBuilder.bind(demoQueue).to(demoTopic).with("demo.route");
    }
    @Bean
    public DemoReceiver demoReceive() {
        return new DemoReceiver();
    }
}
