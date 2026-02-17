# TodoList Application

A Todo List API built with **Java + Spring Boot**, featuring **JWT-based authentication** and **Spring Security**.

This project was developed for learning purposes, focusing on REST APIs, authentication, and deployment-ready architecture.

---

## Features

- User registration and authentication
- JWT-based stateless security
- Create, read, update and delete tasks (CRUD)
- Ready for deployment

---

## Technologies

### Backend
- Java
- Spring Boot
- JPA/Hibernate
- Spring Security
- JWT
- Docker
- Maven
- MariaDB

### Frontend
- HTML5
- CSS3
- JavaScript (Vanilla)

---

## Running the Project Locally

### Prerequisites
- Java 11+
- Maven
- MariaDB

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/lucas-case-dv/todolist.git
2. Navigate to the project folder:
   ```bash
   cd todolist
3. Set the environment variables:
   ```text
   DB_URL=jdbc:mariadb://localhost:3306/todolist?createDatabaseIfNotExist=true
   DB_USERNAME=your_mariadb_username
   DB_PASSWORD=your_mariadb_password
4. Run the application:
   ```bash
   mvn spring-boot:run
5. Open in your browser:
   ```bash
   http://localhost:8080

---

## Authentication
The application uses JWT (JSON Web Token) for authentication.
- Login generates a JWT token
- The token must be sent in the Authorization header for protected routes
- The application is stateless

---

## Endpoints
- GET User: ``/user/{id}``
- POST User: ``/user``
- UPDATE/DELETE User: ``/user/{id}``
- GET Task: ``/task/{id}``
- GET Tasks by User: ``/task/user/{id}``
- POST Task: ``/task``
- UPDATE/DELETE Task: ``/task{id}``
- POST Login: ``/login``
---

## License
This project is for educational purposes.
