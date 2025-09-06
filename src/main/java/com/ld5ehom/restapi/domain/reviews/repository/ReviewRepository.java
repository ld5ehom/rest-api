package com.ld5ehom.restapi.domain.reviews.repository;

import com.ld5ehom.restapi.domain.reviews.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    // Find reviews for a specific book and order them by creation date in descending order
    // 특정 책의 리뷰를 작성일 기준 내림차순으로 조회하는 메소드
    List<Review> findByBookIdOrderByCreatedDateDesc(Long bookId);
}
