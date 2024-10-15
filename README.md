# Spring Boot REST API with Security and Database Integration
ToolShare is a web application for managing tool rentals. Whether you’re a DIY enthusiast or a professional contractor, ToolShare allows users to browse, rent, and return tools from a wide selection of equipment categories. Built with Node.js, Express, and MongoDB, ToolShare provides a scalable and efficient backend solution for managing rental services.

## Project Overview
This project is a secure RESTful API built with Spring Boot, leveraging Spring Data JPA and Spring Data REST to interact with a MySQL database. It provides CRUD operations along with authentication and authorization features, offering role-based access control for endpoints.


## Features
- CRUD operations on entities via REST API.
- Authentication and authorization using Spring Security.
- Integration with MySQL database using Spring Data JPA.
- Automated REST endpoints via Spring Data REST.
- Pagination, sorting, and exception handling.

## Technologies Used
- Spring Boot 3
- Spring Data JPA & REST
- Spring Security
- MySQL
- Maven

## Installation
1. clone the repo:
   git clone [https://github.com/your-username/ToolShare.git](https://github.com/e5m41l/Spring-Boot-REST-API-with-Security-and-Database-Integration.git)
   cd ToolShare
2. Configure the database in application.properties.
   npm install
3. Build the project with Maven:
   mvn clean install
4. Run the application:
   mvn spring-boot:run
5. Test API endpoints using Postman or a similar tool.

## API Endpoints
- POST /api/employees: Create an employee
- GET /api/employees/{id}: Get employee by ID
- PUT /api/employees/{id}: Update employee
- DELETE /api/employees/{id}: Delete employee
## Authentication
- Basic Authentication with username and password.
- Role-based access to endpoints (e.g., ADMIN vs. USER).
## Future Improvements
- Add JWT-based authentication.
- Implement more granular access controls.
