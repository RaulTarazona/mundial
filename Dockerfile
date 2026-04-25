FROM openjdk:21
COPY ./target/mundial-1.jar app.jar
EXPOSE 8222
ENTRYPOINT ["java", "-jar", "app.jar"]
