package com.example.orderservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {
    
    @Value("${spring.kafka.template.default-topic}")
    private String topic;

    @Bean
    public NewTopic createTopic(){
        return TopicBuilder.name(topic).partitions(1).build();
    }
}
