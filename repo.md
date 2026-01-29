# nisarg-kafka

This repository contains a Kafka-based system with a producer and a consumer module implemented using Spring Boot.

## Project Structure

- **root**: Contains the parent `pom.xml` and Docker Compose configuration.
- **producer**: A Spring Boot application that produces messages to Kafka.
- **consumer**: A Spring Boot application that consumes messages from Kafka.

## Infrastructure

The project uses Docker Compose to set up the necessary infrastructure:
- **Kafka**: Broker running on port `9092` (internal) and `29092` (host).
- **Kafka UI**: Accessible at `http://localhost:8090` to monitor topics and messages.

## Modules

### Producer
- **Package**: `com.nisarg.kafka.producer.producer`
- **Main Class**: `ProducerApplication`
- **Controller**: `ProducerController` - REST endpoint for triggering location updates.
- **Service**: `LocationService` - Handles the logic for sending location data to Kafka.
- **Configuration**: `KafkaConfig` handles topic creation.
- **Properties**: Defined in `application.properties`.
- **Default Topic**: `current-location`

### Consumer
- **Package**: `com.nisarg.kafka.consumer`
- **Main Class**: `ConsumerApplication`
- **Properties**: Defined in `application.yaml`.
- **Default Topic**: `location-topic` (Note: Potential inconsistency with producer's default topic)

## Getting Started

1. Start the infrastructure:
   ```bash
   docker-compose up -d
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the Producer and Consumer applications.
