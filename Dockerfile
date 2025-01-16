# Based on the official OpenJDK runtime image
FROM openjdk:17-jdk-slim

# set up file
WORKDIR /app

# Copy the packaged JAR file to the image
COPY runnerz-0.0.1-SNAPSHOT.jar /app/app.jar

#ENV SPRING_PROFILES_ACTIVE=docker

# Expose the port the application is running on (can be set according to your application)
EXPOSE 8080

# run java application
ENTRYPOINT ["java", "-jar", "app.jar"]
