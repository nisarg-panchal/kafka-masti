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

  private KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String topic, String message) {
    log.info("Sending message:{}", message);
    if (topic == null) {
      log.warn("Topic is null, cannot send message");
      return;
    }
    log.info("Sending message to topic: {} with message: {}", topic, message);
    kafkaTemplate.send(topic, message);
  }
}
