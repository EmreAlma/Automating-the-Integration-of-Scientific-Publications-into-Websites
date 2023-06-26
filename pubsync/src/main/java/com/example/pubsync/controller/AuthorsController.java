package com.example.pubsync.controller;

import com.example.pubsync.model.Authors;
import com.example.pubsync.repository.AuthorsRepository;
import org.springframework.web.bind.annotation.GetMapping;

public class AuthorsController {
    private final AuthorsRepository.AuthorRepository authorRepository;

    public AuthorsController(AuthorsRepository.AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/create")
    public Authors getAuthor(){
        Authors authors=new Authors();
        authors.setName("");
        authors.setLastName("");
        authors.setActive(true);
        authorRepository.save(authors);
        return authors;

    }
}
