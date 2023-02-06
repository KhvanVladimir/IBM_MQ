package com.example.springboot.controllers;

import com.example.springboot.Book;
import com.ibm.mq.jakarta.jms.MQQueue;
import jakarta.jms.JMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RequestMapping("main")
@RestController
public class MainController {

    @Autowired
    JmsTemplate jmsTemplate;

    @PostMapping
    public ResponseEntity<String> createXZ(@RequestBody Book book) throws JMSException {
        MQQueue mqQueue = new com.ibm.mq.jakarta.jms.MQQueue("testApp");
        jmsTemplate.convertAndSend(mqQueue, "123");
        return new ResponseEntity(book, HttpStatus.ACCEPTED);
    }
}
