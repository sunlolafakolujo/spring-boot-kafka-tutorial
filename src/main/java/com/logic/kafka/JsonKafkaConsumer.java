package com.logic.kafka;

import com.logic.model.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "kafka-topic", groupId = "myGroup")
    public void consumeJson(AppUser appUser) {

        LOGGER.info(String.format("message sent -> %s", appUser));
    }
}
