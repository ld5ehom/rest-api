package com.ld5ehom.restapi.domain.authors.service;

import com.ld5ehom.restapi.domain.authors.entity.Author;
import com.ld5ehom.restapi.domain.authors.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Save a new author or update an existing one
    // 저자 정보를 저장하거나 기존 저자 정보를 업데이트하는 메소드
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Find an author by ID
    // ID로 특정 저자를 조회하는 메소드
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    // Retrieve all authors
    // 모든 저자 목록을 조회하는 메소드
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
