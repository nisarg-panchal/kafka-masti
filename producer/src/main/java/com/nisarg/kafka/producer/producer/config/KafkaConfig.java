package com.nisarg.kafka.producer.producer.config;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Slf4j
@Configuration
public class KafkaConfig {

  @Value(value = "${spring.kafka.bootstrap-servers}")
  private String bootstrapAddress;
  @Value(value = "${kafka.topic.name}")
  private String topicName;

  @Bean
  public KafkaAdmin kafkaAdmin() {
    log.info("Creating KafkaAdmin with bootstrap address: {}", bootstrapAddress);
    Map<String, Object> configs = new HashMap<>();
    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    return new KafkaAdmin(configs);
  }

  @Bean
  public NewTopic topic1() {
    log.info("Creating topic '{}' with 1 partition and replication factor 1", topicName);
    return TopicBuilder.name(topicName).partitions(1).replicas(1).build();
  }
}
