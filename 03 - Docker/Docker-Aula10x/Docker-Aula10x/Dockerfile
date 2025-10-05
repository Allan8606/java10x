FROM eclipse-temurin:17
LABEL maintainer="allandev@contato.com"
WORKDIR /app
COPY target/Docker-Aula10x-0.0.1-SNAPSHOT.jar /app/aula-docker.jar
ENTRYPOINT ["java", "-jar", "aula-docker.jar"]
EXPOSE 8080