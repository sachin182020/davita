FROM openjdk:8-jdk-alpine
LABEL description="This is a spring boot application"
COPY target/*.jar app.jar
ENV RDS_HOSTNAME mysql-container
CMD ["java", "-jar", "app.jar"]