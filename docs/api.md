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