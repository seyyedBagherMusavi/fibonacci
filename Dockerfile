FROM openjdk:8-jdk-alpine

COPY /target/*.jar /app.jar

EXPOSE 8080

ENV PROFILE=Production JVM_ARGS=""

VOLUME /tmp /var/log/ /var/

ENTRYPOINT java   -Dspring.profiles.active=$PROFILE  -Duser.timezone=Asia/Tehran  -jar /app.jar
