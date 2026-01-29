package com.nisarg.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@Slf4j
@SpringBootApplication
@EnableKafka
public class ConsumerApplication {

  static void main(String[] args) {
    SpringApplication.run(ConsumerApplication.class, args);
  }

}
