package com.ld5ehom.restapi.domain.authors.controller;

import com.ld5ehom.restapi.domain.authors.entity.Author;
import com.ld5ehom.restapi.domain.authors.request.AuthorRequest;
import com.ld5ehom.restapi.domain.authors.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

// Base URI mapping for Author resources.
// Chosen as /authors to follow REST hierarchical structure.
// Author 리소스에 대한 기본 URI 매핑.
// REST 계층 구조를 따르기 위해 /authors 로 지정함.
@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // Add a new author and return with HATEOAS links
    // 새로운 저자를 추가하고 HATEOAS 링크를 포함해 반환
    @PostMapping
    public ResponseEntity<EntityModel<Author>> addAuthor(@RequestBody AuthorRequest request) {
        Author toSave = new Author();
        toSave.setName(request.getName());

        Author savedAuthor = authorService.saveAuthor(toSave);

        EntityModel<Author> entityModel = EntityModel.of(savedAuthor);
        entityModel.add(linkTo(methodOn(this.getClass()).getAllAuthors()).withRel("all-authors"));
        entityModel.add(linkTo(methodOn(this.getClass()).getAuthorById(savedAuthor.getId())).withRel("author-by-id"));

        return new ResponseEntity<>(entityModel, HttpStatus.CREATED);
    }

    // Get an author by ID
    // ID로 저자 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        return authorService.findById(id)
                .map(author -> new ResponseEntity<>(author, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all authors
    // 모든 저자 목록 조회
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.findAll();
        if (authors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
}
