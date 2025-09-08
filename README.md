# Spring Boot REST API Development

## Project Overview

-   Built a REST API with Spring Boot by setting up the development environment and implementing CRUD endpoints to practice designing RESTful services.
-   Created interactive and verifiable API documentation using Swagger and Spring REST Docs, making it easier to test, share, and maintain endpoints.
-   Applied HATEOAS principles and integrated HAL Explorer to provide hypermedia-driven navigation, allowing clients to dynamically discover related resources within the API.
-   Technologies: Java, Spring Boot, Spring Web, Spring Data JPA, Spring HATEOAS, Spring Boot Actuator, Validation, HAL Explorer, REST Docs, Lombok, H2 Database

---
```angular2html
http://localhost:8080/swagger-ui/index.html#/
```

---

## URI Design for Online Bookstore

### Add a new book
- POST /book

### Retrieve list of books
- GET /books

### Retrieve a specific book
- GET /books/{bookId}

### Retrieve books by author
- GET /books?author={authorName}

### Retrieve reviews for a book
- GET /books/{bookId}/reviews

## Required Tables for Implementation
- book
- author
- review  
