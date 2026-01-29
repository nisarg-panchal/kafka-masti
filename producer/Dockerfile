FROM amazoncorretto:25-alpine-jdk
WORKDIR /app
COPY target/producer-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]