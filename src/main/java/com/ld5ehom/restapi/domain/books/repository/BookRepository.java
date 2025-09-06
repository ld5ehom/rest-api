package com.ld5ehom.restapi.domain.books.repository;

import com.ld5ehom.restapi.domain.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Find books by the author's name
    // 저자 이름으로 책을 조회하는 메소드
    List<Book> findByAuthorsName(String name);

    // Find books with titles containing a given keyword
    // 제목에 특정 키워드를 포함하는 책을 조회하는 메소드
    List<Book> findByTitleContaining(String keyword);
}
