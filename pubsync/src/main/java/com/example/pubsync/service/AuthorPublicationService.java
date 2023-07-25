package com.example.pubsync.service;


import com.example.pubsync.model.Response;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorPublicationService {

    private final AuthorApiService authorApiService;

    private final PublicationDatabaseManager publicationDatabaseManager;

    public AuthorPublicationService(AuthorApiService authorApiService, PublicationDatabaseManager publicationDatabaseManager) {
        this.authorApiService = authorApiService;
        this.publicationDatabaseManager = publicationDatabaseManager;
    }


    public void fetchAndSavePublicationsForAuthors() {
        List<String> authorNames = List.of("Timo_Kehrer", "Sandra_Greiner");

        for (String authorName : authorNames) {
            Response authorData = authorApiService.getAuthorsPage(authorName);
            publicationDatabaseManager.savePublications(authorData);
        }
    }

}