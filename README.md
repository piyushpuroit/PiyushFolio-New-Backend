<<<<<<< HEAD
# Personal Portfolio Backend

This is a production-ready, interview-quality backend built with Spring Boot, Spring Security, and JWT for a personal portfolio website.

## Tech Stack
- **Framework**: Spring Boot 4.0.x / 3.x
- **Security**: Spring Security & stateless JWT Authentication
- **Database**: MySQL with JPA & Hibernate
- **Build Tool**: Maven
- **Lombok** for clean, boilerplate-free code
- **Jakarta Validation** for input validation

---

## Getting Started

### 1. Prerequisites
- Java 17 or higher
- MySQL Database

### 2. Configuration
Create a `.env` file in the root directory (you can copy [.env.example](file:///.env.example) to `.env`):
```env
PORT=8080
DB_URL=jdbc:mysql://localhost:3306/portfolio_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
DB_USER=root
DB_PASSWORD=root
JWT_SECRET=superSecretKeyForPortfolioBackendEnsureItIsLongEnough32Bytes
JWT_EXPIRATION_MS=86400000
ADMIN_USERNAME=admin
ADMIN_PASSWORD=admin123
CORS_ALLOWED_ORIGINS=http://localhost:5173,http://localhost:3000
```

### 3. Build & Run
Run the following command to start the server:
```bash
./mvnw spring-boot:run
```

---

## API Documentation

All response bodies follow a consistent envelope structure:
```json
{
  "success": true,
  "message": "Operation successful",
  "data": { ... }
}
```

### 1. Authentication (Public)
- **POST** `/api/admin/login`
  - Request Body:
    ```json
    {
      "username": "admin",
      "password": "admin123"
    }
    ```
  - Response:
    ```json
    {
      "success": true,
      "message": "Login successful",
      "data": {
        "token": "eyJhbGciOi...",
        "type": "Bearer"
      }
    }
    ```

### 2. Contact Module
- **POST** `/api/contact` (Public) - Submit contact message.
- **GET** `/api/contact` (Admin Only) - Retrieve contact messages (supports sorting, pagination, and search by email).
  - Parameters: `page` (default 0), `size` (default 10), `sortBy` (default `createdAt`), `sortDir` (default `desc`), `email` (optional).
- **GET** `/api/contact/{id}` (Admin Only) - Get single message details.
- **PATCH** `/api/contact/{id}/read` (Admin Only) - Toggle read status.
  - Request Body: `{ "read": true }`
- **DELETE** `/api/contact/{id}` (Admin Only) - Delete message.

### 3. Projects Module
- **GET** `/api/projects` (Public) - Get all projects.
- **GET** `/api/projects/{id}` (Public) - Get project by ID.
- **POST** `/api/projects` (Admin Only) - Create project.
- **PUT** `/api/projects/{id}` (Admin Only) - Update project.
- **DELETE** `/api/projects/{id}` (Admin Only) - Delete project.

### 4. Skills Module
- **GET** `/api/skills` (Public) - Get all skills.
- **POST** `/api/skills` (Admin Only) - Create skill.
- **PUT** `/api/skills/{id}` (Admin Only) - Update skill.
- **DELETE** `/api/skills/{id}` (Admin Only) - Delete skill.

### 5. Education Module
- **GET** `/api/education` (Public) - Get all education records.
- **POST** `/api/education` (Admin Only) - Create education record.
- **PUT** `/api/education/{id}` (Admin Only) - Update education record.
- **DELETE** `/api/education/{id}` (Admin Only) - Delete education record.

### 6. Experience Module
- **GET** `/api/experience` (Public) - Get all experiences.
- **POST** `/api/experience` (Admin Only) - Create experience.
- **PUT** `/api/experience/{id}` (Admin Only) - Update experience.
- **DELETE** `/api/experience/{id}` (Admin Only) - Delete experience.

### 7. Certifications Module
- **GET** `/api/certifications` (Public) - Get all certifications.
- **POST** `/api/certifications` (Admin Only) - Create certification.
- **PUT** `/api/certifications/{id}` (Admin Only) - Update certification.
- **DELETE** `/api/certifications/{id}` (Admin Only) - Delete certification.

### 8. Social Links Module
- **GET** `/api/social-links` (Public) - Get all social links.
- **POST** `/api/social-links` (Admin Only) - Create social link.
- **PUT** `/api/social-links/{id}` (Admin Only) - Update social link.
- **DELETE** `/api/social-links/{id}` (Admin Only) - Delete social link.

### 9. Resume Module
- **GET** `/api/resume` (Public) - Get resume metadata (download URL, last updated).
- **PUT** `/api/resume` (Admin Only) - Update resume metadata.

---

## Postman Collection
Import the provided Postman collection file `portfolio_api_collection.json` in root directory to start testing the APIs.
=======
# PiyushFolio-New-Backend
>>>>>>> 1b1df1228460030f077c7fcd6422153e6ac96c5b
