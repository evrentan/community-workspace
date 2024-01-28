ARG APP_JAR=event-manager-1.0.0.jar
FROM gradle:8.5-jdk21 AS build
COPY . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test

FROM openjdk:21
LABEL maintainer="Evren Tan"
ARG APP_JAR
ENV APP_JAR_ENV=$APP_JAR
EXPOSE 8833
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/${APP_JAR_ENV} /app/${APP_JAR_ENV}
ENTRYPOINT java -jar /app/${APP_JAR_ENV}