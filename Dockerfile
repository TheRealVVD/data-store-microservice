FROM maven:3.9.0-openjdk-19 AS build
COPY /src /src
COPY pom.xml /
RUN mvn -f /pom.xml clean package

FROM openjdk:19-jdk-slim
COPY --from=build /target/*.jar application.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "application.jar"]