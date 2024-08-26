FROM openjdk:11-jdk-slim

WORKDIR /app

COPY target/microblogging-app.jar /app/microblogging-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "README 2.md-jar", "/app/microblogging-app.jar"]