#
# Build stage
#
FROM maven:3.8.4-openjdk-8 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /app/src/
RUN mvn package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:8-jdk-slim
WORKDIR /app
COPY --from=build /app/target/HospitalManagementSystem-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
