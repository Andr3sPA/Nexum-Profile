FROM eclipse-temurin:21-jdk-alpine as build
WORKDIR /app
COPY ./build/libs/profile-0.0.1-SNAPSHOT.jar app.jar

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/app.jar app.jar
EXPOSE 8100
ENTRYPOINT ["java", "-jar", "app.jar"]
