FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/mundial-1.jar app.jar
EXPOSE 10000
ENV SERVER_PORT=10000
ENTRYPOINT ["java", "-jar", "app.jar"]
