package com.logic.kafka;

import com.logic.model.AppUser;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, AppUser> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, AppUser> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(AppUser appUser){

        LOGGER.info(String.format("Message sent -> %s", appUser.toString()));

        Message<AppUser> message= MessageBuilder
                .withPayload(appUser)
                .setHeader(KafkaHeaders.TOPIC,"json-kafka-topic")
                .build();

        kafkaTemplate.send(message);
    }

}
