package com.example.rabbitmq;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Producer {

    public static String DEMO_ROUTE = "demo.route";

    @Bean
    public TopicExchange demoTopic() {
        return new TopicExchange("demo.topic");
    }

    @Bean
    public FanoutExchange fanoutDemoActive() {
        return new FanoutExchange("demo.fanout");
    }

    @Bean
    public SenderService sender() {
        return new SenderService();
    }
}
