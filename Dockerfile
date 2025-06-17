FROM eclipse-temurin:21-jdk

LABEL authors="Usuário"

WORKDIR /app

COPY target/urlShortener-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]