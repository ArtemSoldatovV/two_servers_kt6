FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/order-service.jar order-service.jar
ENTRYPOINT ["java", "-jar", "order-service.jar"]