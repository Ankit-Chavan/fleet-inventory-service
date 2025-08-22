FROM openjdk:11-jre-slim
VOLUME /tmp
COPY target/fleet-inventory-service.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]