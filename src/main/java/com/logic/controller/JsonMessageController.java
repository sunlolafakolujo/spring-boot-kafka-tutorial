package com.logic.controller;

import com.logic.kafka.JsonKafkaProducer;
import com.logic.model.AppUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/jsonKafka")
public record JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {

    @PostMapping("/publishUser")
    public ResponseEntity<String> getMessage(@RequestBody AppUser appUser){
        jsonKafkaProducer.sendMessage(appUser);
        return ResponseEntity.ok("Json User successfully create");
    }
}
