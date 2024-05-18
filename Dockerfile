FROM openjdk:21-jdk-slim
LABEL authors="chrisio"

WORKDIR /app

COPY target/wenxige-bg-0.1.0.jar app.jar

EXPOSE 8080

ENV MYSQL_HOST=localhost
ENV MYSQL_DATABASE=wenxigedb

ENTRYPOINT ["java", "-jar", "app.jar"]