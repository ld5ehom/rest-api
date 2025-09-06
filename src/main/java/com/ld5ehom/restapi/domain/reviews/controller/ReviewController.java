package com.ld5ehom.restapi.domain.reviews.controller;

import com.ld5ehom.restapi.domain.reviews.entity.Review;
import com.ld5ehom.restapi.domain.reviews.service.ReviewService;
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
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Add a new review for a specific book
    @PostMapping("/{bookId}/reviews")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        Review savedReview = reviewService.saveReview(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    // Get all reviews for a specific book
    @GetMapping("/{bookId}/reviews")
    public ResponseEntity<List<Review>> getReviewsByBookId(@PathVariable Long bookId) {
        List<Review> reviews = reviewService.findByBookId(bookId);
        if (reviews.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // Delete a review by ID for a specific book
    @DeleteMapping("/{bookId}/reviews/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long bookId, @PathVariable Long id) {
        reviewService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
