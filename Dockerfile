FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests -Dspring.profiles.active=prod

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/portfolio-api-0.0.1-SNAPSHOT.jar portfolio-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","portfolio-api.jar"]