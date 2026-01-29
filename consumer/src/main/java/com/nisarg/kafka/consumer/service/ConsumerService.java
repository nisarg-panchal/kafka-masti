package com.nisarg.kafka.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {

  @KafkaListener(topics = "location-service")//TODO - figure out proper way to mention
  public void consumeMessage(String message) {
    log.info("Received message: {}", message);
  }
}
