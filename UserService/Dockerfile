FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/user-service.jar user-service.jar
ENTRYPOINT ["java", "-jar", "user-service.jar"]