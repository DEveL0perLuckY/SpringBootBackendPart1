Hello Gies welcome to my spring boot backend in whcih complete rest api and thyemleaf fronend i create you have to setup your database configuration in applaication properties and currenty i am using oracle database and you got it.
# Spring Boot Backend with REST API and Thymeleaf Frontend

Welcome to the Spring Boot project that includes a complete REST API and a Thymeleaf frontend. In this project, we'll provide you with instructions on how to set up your database configuration for Oracle in the `application.properties` file.

## Prerequisites

Before you get started, ensure that you have the following prerequisites:

- Java Development Kit (JDK)
- Spring Boot installed
- Oracle Database (with necessary credentials and connection details)

## Database Configuration

To configure your Oracle database connection, follow these steps:

1. Open the `application.properties` file located in your Spring Boot project's `src/main/resources` directory.

2. Find the section related to database configuration. It should look something like this:

```properties
# Database properties
spring.datasource.url=jdbc:oracle:thin:@your-oracle-server:1521:your-database
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
