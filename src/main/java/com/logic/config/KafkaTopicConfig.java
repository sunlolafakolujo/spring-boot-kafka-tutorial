package com.logic.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic logicTopic(){
        return TopicBuilder.name("kafka-topic")
                .build();
    }

    @Bean
    public NewTopic kafkaJsonTopic(){
        return TopicBuilder.name("json-kafka-topic")
                .build();
    }
}
