package com.shsa.rabbitmqspringboot.controller;

import com.shsa.rabbitmqspringboot.model.QueueObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DefaultController {

    @Autowired
    private AmqpTemplate defaultExchange;

    @PostMapping("default")
    public ResponseEntity<?> sendMessageWithDefaultExchange(){
        QueueObject object = new QueueObject("default", LocalDateTime.now());

        defaultExchange.convertAndSend(object);

        return ResponseEntity.ok(true);
    }

}
