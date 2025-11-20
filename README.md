# Freely - Freelancer Platform Backend

## Overview

Freely is a Spring Boot-based backend application for a freelancer platform that connects freelancers with clients. The system manages user accounts, profiles, and platform interactions.

## Prerequisites

- **Java Development Kit (JDK)**: Version 17 or higher
- **Maven**: Version 3.6 or higher
- **PostgreSQL**: Version 12 or higher
- **Git**: For version control
- **IDE**: IntelliJ IDEA 2025.2.4 (recommended), Eclipse, or VS Code with Java extensions

## Technology Stack

- **Framework**: Spring Boot 3.x
- **Language**: Java 17+
- **Build Tool**: Maven
- **Database**: PostgreSQL
- **ORM**: Hibernate/JPA
- **API**: RESTful Web Services

## Core Dependencies

### Spring Boot Starters
- `spring-boot-starter-web` - REST API development and embedded Tomcat server
- `spring-boot-starter-data-jpa` - Database operations and ORM with Hibernate
- `spring-boot-starter-validation` - Bean validation with annotations (`@NotNull`, `@Email`, etc.)
- `spring-boot-starter-security` - Authentication and authorization (if implemented)

### Database
- `postgresql` - PostgreSQL JDBC driver for database connectivity

### Additional Dependencies
- Lombok (optional) - Reduces boilerplate code
- Spring Boot DevTools (optional) - Hot reload during development

## Database Setup

1. **Install PostgreSQL** on your system

2. **Create Database**:
```sql
CREATE DATABASE freely_db;

# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/freely_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true

# Server Configuration
server.port=8080

# CORS Configuration (for frontend integration)
# Configure this in your WebConfig class
