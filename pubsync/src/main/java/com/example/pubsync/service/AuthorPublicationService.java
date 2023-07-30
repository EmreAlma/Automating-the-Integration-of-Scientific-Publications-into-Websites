package com.example.pubsync.service;


import com.example.pubsync.entity.Authors;
import com.example.pubsync.model.Response;
import com.example.pubsync.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorPublicationService {

    private final AuthorApiService authorApiService;

    private final PublicationDatabaseManager publicationDatabaseManager;

    private  final AuthorRepository authorRepository;
    public AuthorPublicationService(AuthorApiService authorApiService, PublicationDatabaseManager publicationDatabaseManager, AuthorRepository authorRepository) {
        this.authorApiService = authorApiService;
        this.publicationDatabaseManager = publicationDatabaseManager;
        this.authorRepository = authorRepository;
    }


    public void fetchAndSavePublicationsForAuthors() {
        List<Authors> authors = authorRepository.findAll();

        for (Authors author : authors) {
            String formattedName = formatAuthorName(author);
            Response authorData = authorApiService.getAuthorsPage(formattedName);
            publicationDatabaseManager.savePublications(authorData, author);
        }
    }

    private String formatAuthorName(Authors author) {
        String firstName = author.getName();
        String lastName = author.getLastName();

        firstName = firstName.replace(" ", "_");
        lastName = lastName.replace(" ", "_");

        return firstName + "_" + lastName;
    }

}