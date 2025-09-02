#### CREACION DEL JAR ####
FROM maven:3.9.9-eclipse-temurin-21-alpine AS builder

WORKDIR /app
COPY ./pom.xml .
COPY ./lombok.config ./
RUN mvn -e -B dependency:go-offline
COPY ./src ./src
RUN mvn -e -B -Dmaven.test.skip=true package

#### FASE FINAL DE LA IMAGEN ####
FROM openjdk:21-slim

WORKDIR /workspace

ARG mypassword
ENV host="postgres_server"
ENV port="5432"
ENV db.username="mito-students"
ENV username="postgres"
ENV password=$mypassword

COPY --from=builder /app/target/mito*.jar app.jar

#no abre ningun puerto, es solo informativo
EXPOSE 8787 
ENTRYPOINT exec java -jar /workspace/app.jar