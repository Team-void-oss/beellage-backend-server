# Dockerfile for Spring Boot Backend
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built application JAR file into the container
COPY build/libs/issuetracker-0.0.1-SNAPSHOT.jar issue-tracker.jar

# Expose the port the application will run on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java","-jar","/app/issue-tracker.jar"]
