#
#FROM maven:4.0.0-openjdk:17 as builder
#WORKDIR /app
#COPY pom.xml .
#RUN mvn dependency:go-offline
#COPY src/ ./src/
#RUN mvn clean package -DskipTests=true
#
#
#FROM eclipse-temurin:17-jdk-alpine as prod
#RUN mkdir /app
#COPY --from=builder /app/target/*.jar /app/app.jar
#ENV SERVER_PORT=6060
#WORKDIR /app
#EXPOSE 6060
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:17-jdk-alpine
COPY target/*.jar /apiecomerce.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/apiecomerce.jar"]