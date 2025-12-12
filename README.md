![Java](https://img.shields.io/badge/Java-25-orange) ![License: Free Use](https://img.shields.io/badge/License-Free--Use-green) ![Patika.dev](https://img.shields.io/badge/Patika.dev-Project-blue)  
![GitHub stars](https://img.shields.io/github/stars/ayhan-unlu/JobSearch?style=social) ![GitHub forks](https://img.shields.io/github/forks/ayhan-unlu/JobSearch?style=social) ![GitHub last commit](https://img.shields.io/github/last-commit/ayhan-unlu/OnlineCv)


Online CV Project (Under Construction)

Online CV Project is a full-stack web application for managing job seeker CVs and candidate profiles. Users can submit their professional information, while admins (HR) will be able to efficiently review, filter, and manage candidates based on specific criteria.

⚠️ Project Status: Currently under construction. Core features have been implemented, but some functionalities are still in development and the project is not fully finished.

🎯 Features (Planned / In Progress)
User Features

User registration & authentication (with password hashing)

Login restrictions: 3 attempts maximum, blocked if exceeded

Create and edit CV information:

Name, surname, phone, field of experience

Work experience (years)

Military service status

CV retention duration (KVKK compliance)

View personal profile in a User Dashboard

Admin (HR) Features

Admin login & secure session

Admin dashboard to access all registered users

Filter users by:

Military service completed

Minimum 5 years of experience

View detailed candidate information

Logging of actions for auditing

Platform Features

Role-based dashboards (USER / ADMIN)

Full Spring Security integration

MySQL database for persistence

Thymeleaf-based UI (React/Angular optional)

Service layer for business logic and filtering

Logging all user and admin actions

Paging / pagination for large datasets

🏗️ Architecture

The application follows a layered architecture:

Layer	Description
Controller Layer	Thymeleaf pages, routing, dashboards
Service Layer	Business logic, filtering, login attempts
Repository Layer	JPA repositories for User and CV entities
Entity Layer	Hibernate-mapped domain objects, enums, optional fields
Security Layer	AuthenticationProvider, Spring Security, login restrictions
Database Layer	MySQL with proper relations: Admin (1) → User (N)
⚙️ Tech Stack
Layer / Component	Technology
Backend	Spring Boot 4
Security	Spring Security
ORM / DB	Hibernate / JPA + MySQL
Frontend	HTML, Thymeleaf (React/Angular optional)
Build Tool	Maven
Language	Java 25
Logging	SLF4J / Logback
Design Patterns	Interface, Abstract, Inheritance, Stream API, Optional, Enum
🚀 Getting Started

Clone the repository

git clone https://github.com/ayhan-unlu/JobSearch.git
cd JobSearch


Configure MySQL

CREATE DATABASE onlinecv;


Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/onlinecv
spring.datasource.username=yourUser
spring.datasource.password=yourPassword
spring.jpa.hibernate.ddl-auto=update


Run the project

mvn spring-boot:run


The application runs at: http://localhost:8080

(Note: Some features are still under development and may not work fully.)

🧪 Testing (In Progress)

Manual UI testing via browser

Service-layer filtering validation

Login flow & session management (blocked users)

Controller → Service → Repository integration checks

Optional: JUnit test cases for service & repository layer

🗂️ Directory Structure
src/main/java/com.ayhanunlu
├── controller/
├── data/
│    ├── dto/
│    ├── entity/
│    ├── repository/
├── enums/
├── security/
├── service/
│    ├── impl/
└── Application.java

src/main/resources/
├── templates/ (Thymeleaf views)
└── application.properties

📄 License

MIT License – free use, modification, and distribution.

👤 Developer

Ayhan Ünlü – Java & Spring Boot Developer

Demonstrates expertise in:

Spring Boot layered architecture

Role-based security & login restrictions

JPA/Hibernate ORM

MVC with Thymeleaf (or React/Angular)

Clean code, S.O.L.I.D principles, design patterns

📦 Project Status

Under Construction – Core features implemented, but work is ongoing to:

Complete all user/admin functionalities

Finalize login and CV management flows

Implement full filtering and paging

Enhance logging and testing