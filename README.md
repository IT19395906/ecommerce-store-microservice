# 🛒 Order Management System

This is an **Springboot Microservice based System** designed **Maven multi-module architecture** for managing Inventory, Product with **role-based access control**. The application allows different types of users (Admins and Normal Users) to interact with the system based on their roles. Provides **synchronous (WebClient)** and **asynchronous (Kafka)** inter-service communication

## 🛠️ Tech Stack & Tools

- **Spring Boot**
- **Spring Security + JWT**
- **Lombok** for reducing boilerplate code
- **MySQL** for data persistence
- **DTO & Validation Annotations** for clean request/response handling
- **Exception Handling** using global handler and custom exceptions
- **ModelMapper** for DTO/entity conversions
- **Spring Data JPA**
- **Spring WebFlux** for non blocking communication
- **Kafka** for core services asynchronus communication
- **Eureka** for service discovery
