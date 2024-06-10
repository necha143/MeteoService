FROM openjdk:17

ARG APP_JAR=*.jar

COPY ${APP_JAR} MeteoService.jar

ENTRYPOINT ["java", "-jar", "MeteoService.jar"]

EXPOSE 8080