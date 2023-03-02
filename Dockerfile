FROM maven:3.9.0-amazoncorretto-19 AS build

WORKDIR /app
COPY . /app
RUN mvn package -DskipTests

FROM openjdk:19-slim-buster
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]