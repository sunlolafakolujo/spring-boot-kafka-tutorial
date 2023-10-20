package com.logic.controller;

import com.logic.kafka.KafkaConsumer;
import com.logic.kafka.KafkaProducer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/kafka")
public record MessageController(KafkaProducer kafkaProducer, KafkaConsumer kafkaConsumer) {

    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return new ResponseEntity<>("Message successfully published to the topic", HttpStatus.OK);
    }
}
