# Use official OpenJDK 17 image from Docker Hub
FROM eclipse-temurin:17-jdk

# Expose application port
EXPOSE 8443

# Set working directory
WORKDIR /app

# Use root to set up directories
USER root

# Copy the application JAR file
COPY target/ms-sandbox-service.jar ms-sandbox-service.jar

# Create necessary folders and assign ownership
RUN mkdir -p /app/cert/ /app/serviceLog/ && \
    groupadd -r appuser && useradd -r -g appuser ubuntu && \
    chown -R ubuntu:appuser /app

# Switch to non-root user
USER ubuntu

# Entry point to run the app
ENTRYPOINT ["java", "-jar", "ms-sandbox-service.jar"]
