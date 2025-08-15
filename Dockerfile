FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/moneymate-0.0.1-SNAPSHOT.jar moneymate-v1.jar
EXPOSE 9090
ENTRYPOINT["java", "-jar", "moneymate-v1.jar"]