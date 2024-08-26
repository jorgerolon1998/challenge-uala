package com.example.platform.async;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public TopicExchange tweetsExchange() {
        return new TopicExchange("tweets_exchange");
    }

    @Bean
    public Queue tweetsQueue() {
        return new Queue("tweets_queue");
    }

    @Bean
    public Binding binding(Queue tweetsQueue, TopicExchange tweetsExchange) {
        return BindingBuilder.bind(tweetsQueue).to(tweetsExchange).with("tweets_routing_key");
    }
}
