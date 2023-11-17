FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar curd-basic.jar
ENTRYPOINT ["java","-jar","/curd-basic.jar"]
EXPOSE 8080