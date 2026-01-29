package com.nisarg.kafka.producer.producer.controller;

import com.nisarg.kafka.producer.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/producer/")
@RequiredArgsConstructor
public class ProducerApi {

  private final ProducerService producerService;

  @GetMapping("echo")
  public String echo(String optionalInputToEcho) {
    log.info("Echoing from producer API:{}", optionalInputToEcho);
    return "Echoed: " + optionalInputToEcho;
  }

  @PostMapping("send")
  public ResponseEntity<String> sendMessage(String topic, String message) {
    log.info("Sending message: topic={}, message={}", topic, message);
    producerService.sendMessage(topic, message);
    return ResponseEntity.ok("Message sent successfully");
  }
}
