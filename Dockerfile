# Dockerfile for Spring Boot Backend
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/*.jar issue-tracker.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/issue-tracker.jar"]
