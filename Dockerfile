FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim


ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=portfolio

RUN apt-get update && \
    apt-get install -y mysql-server && \
    rm -rf /var/lib/apt/lists/*

COPY --from=build /target/portfolio-api-0.0.1-SNAPSHOT.jar portfolio-api.jar

RUN service mysql start && \
    mysql -e "CREATE DATABASE IF NOT EXISTS ${MYSQL_DATABASE};" && \
    mysql -e "ALTER USER 'root'@'localhost' IDENTIFIED BY '${MYSQL_ROOT_PASSWORD}';" && \
    service mysql stop

EXPOSE 8080 3306
ENTRYPOINT ["java","-jar","portfolio-api.jar"]