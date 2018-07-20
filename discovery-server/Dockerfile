FROM openjdk:8
COPY target/discovery-server.jar /app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/app.jar"]
HEALTHCHECK CMD curl --fail http://localhost:8761/actuator/health || exit 1
