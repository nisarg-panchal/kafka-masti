package com.nisarg.kafka.producer.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerService {
  @Value("${kafka.topic.name}")
  private String topicName;

  private final KafkaTemplate<String, Object> kafkaTemplate;

  public void sendMessage(String message) {
    assert kafkaTemplate != null : "KafkaTemplate cannot be null";
    log.info("Sending message to topic: {} with message: {}", topicName, message);
    kafkaTemplate.send(topicName, message);
  }
}
