package com.ld5ehom.restapi.domain.books.controller;

import com.ld5ehom.restapi.domain.books.entity.Book;
import com.ld5ehom.restapi.domain.books.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Base URI mapping for Book resources.
// Chosen as /books to follow REST hierarchical structure.
// Book 리소스에 대한 기본 URI 매핑.
// REST 계층 구조를 따르기 위해 /books 로 지정함.
@RestController
@RequestMapping("/books")
@Tag(name = "books", description = "Book related API")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Add a new book
    @PostMapping
    @Operation(summary = "Add a new book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    // Get a book by ID
    @GetMapping("/{id}")
    @Operation(summary = "Retrieve a book by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Book retrieved successfully"),
                    @ApiResponse(responseCode = "404", description = "Book not found")
            }
    )
    public ResponseEntity<Book> getBookById(@Parameter(description = "Book ID") @PathVariable Long id) {
        return bookService.findById(id)
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all books or filter by author name
    @GetMapping
    @Operation(summary = "Retrieve all books or filter by author name")
    public ResponseEntity<List<Book>> getBooks(@RequestParam(required = false) String author) {
        if (author != null && !author.isEmpty()) {
            return new ResponseEntity<>(bookService.findByAuthorName(author), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
        }
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a book by ID")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
