# Stage 1 - Build
FROM maven:3.6.3-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Stage 2 - Run
FROM openjdk:8
COPY --from=build /home/app/target/qr_payment_project_api.jar /usr/local/lib/qr_payment_project_api.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/usr/local/lib/qr_payment_project_api.jar"]