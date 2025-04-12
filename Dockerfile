# 🏗️ Build Stage: Uses Maven to compile the JAR
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY pom.xml .

# Download dependencies before copying source code (better caching)
RUN mvn dependency:go-offline

# Copy source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# 🚀 Run Stage: Use a smaller JDK image to run the app
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 7071

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
