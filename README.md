![Java](https://img.shields.io/badge/Java-25-orange) ![License: Free Use](https://img.shields.io/badge/License-Free--Use-green) ![Patika.dev](https://img.shields.io/badge/Patika.dev-Project-blue)  
![GitHub stars](https://img.shields.io/github/stars/ayhan-unlu/JobSearch?style=social) ![GitHub forks](https://img.shields.io/github/forks/ayhan-unlu/JobSearch?style=social) ![GitHub last commit](https://img.shields.io/github/last-commit/ayhan-unlu/OnlineCv)


# Online CV Project

Online CV Project is a full-stack web application built with modern Spring technologies.  
It enables job seekers to manage their CVs and personal profiles, while providing admins (HR) efficient tools for filtering and reviewing candidates.

The system is fully functional, end-to-end tested, and ready for deployment.

---

## 🎯 Features

**User Features**
- User registration & authentication
- Role-based dashboard (USER)
- View personal profile (CV details)
    - Name, surname, phone
    - Field of experience
    - Work experience (years)
    - Military service status
    - CV retention duration (KVKK compliance)
- Secure logout and session handling

**Admin Features**
- Admin login & secure session
- Admin dashboard
- View full list of registered users
- Filter users by:
    - Military service completed
    - Minimum 5 years of experience

**Platform Features**
- Full Spring Security integration
- Persistent user data
- Service layer handles business logic and filtering
- Thymeleaf-based UI
- MySQL relational database
- Logging of key actions (registration, login, dashboard access)
- Paging / pagination for large datasets

---

## 🏗️ Architecture

The application follows a layered architecture:

| Layer | Description |
|-------|-------------|
| Controller Layer | Thymeleaf pages, routing, dashboards |
| Service Layer | Business logic, filtering, login attempts |
| Repository Layer | JPA repositories for User entities |
| Entity Layer | Hibernate-mapped domain objects, enums, optional fields |
| Security Layer | AuthenticationProvider, RBAC, session management |
| Database Layer | MySQL schema with Admin (1) → User (N) relationships |

---

## ⚙️ Tech Stack

| Layer / Component | Technology |
|------------------|------------|
| Backend | Spring Boot 4 |
| Security | Spring Security |
| ORM / DB | Hibernate / JPA + MySQL |
| Frontend | HTML + Thymeleaf |
| Build Tool | Maven |
| Language | Java 25 |
| Logging | SLF4J / Logback |
| Design Patterns | Interface, Abstract, Inheritance, Stream API, Optional, Enum |

---

🚀 Getting Started

Clone the repository: git clone https://github.com/ayhan-unlu/OnlineCV.git and cd OnlineCV

Configure MySQL: CREATE DATABASE onlinecvdb;

Update application.properties with your database credentials:
spring.datasource.url=jdbc:mysql://localhost:3306/onlinecvdb
spring.datasource.username=yourUser
spring.datasource.password=yourPassword
spring.jpa.hibernate.ddl-auto=update

Run the project: mvn spring-boot:run

Access the application at: http://localhost:8080

🧪 Testing

The project allows: manual UI testing via browser, service-layer filtering validation, login flow and session management (blocked users), and Controller → Service → Repository integration checks. Optional: JUnit test cases for service & repository layer can be added.

🗂️ Directory Structure

src/main/java/com.ayhanunlu
├── controller/
├── data/
│ ├── dto/
│ ├── entity/
│ ├── repository/
├── enums/
├── security/
├── service/
│ ├── impl/
└── Application.java

src/main/resources/
├── templates/ (Thymeleaf views)
└── application.properties

📄 License

This project is licensed under MIT License – free use, modification, and distribution.

👤 Developer

Ayhan Ünlü – Java & Spring Boot Developer

Demonstrates expertise in Spring Boot layered architecture, role-based security & login restrictions, JPA/Hibernate ORM, MVC with Thymeleaf, clean code, and S.O.L.I.D principles.

📦 Project Status

Completed

