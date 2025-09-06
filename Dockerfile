# Use official Maven image to build the app
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use lightweight JDK runtime to run the app
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/message-generator-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
