package com.example.pubsync.service;

import com.example.pubsync.entity.Author;
import com.example.pubsync.model.Response;
import com.example.pubsync.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/** This class responsible for fetching and saving publications for authors and
 *  interacting with the publication database.
 */
@Service
public class AuthorPublicationService {

    private final AuthorApiService authorApiService;

    private final PublicationDatabaseManager publicationDatabaseManager;

    private  final AuthorRepository authorRepository;

    /** Constructor for AuthorPublicationService class.
     * @param authorApiService  Service for interacting with the author API.
     * @param publicationDatabaseManager    Manager for interacting with the publication database.
     * @param authorRepository  Repository for accessing author data.
     */
    public AuthorPublicationService(AuthorApiService authorApiService, PublicationDatabaseManager publicationDatabaseManager, AuthorRepository authorRepository) {
        this.authorApiService = authorApiService;
        this.publicationDatabaseManager = publicationDatabaseManager;
        this.authorRepository = authorRepository;
    }

    /** This method retrieves author information, queries DBLP API, and then saves the fetched publications
     * into the database.*/
    public void fetchAndSavePublicationsForAuthors() {
        List<Author> authors = authorRepository.findAll();

        for (Author author : authors) {
            String formattedName = formatAuthorName(author);
            Response authorData = authorApiService.getAuthorsPage(formattedName);
            publicationDatabaseManager.savePublications(authorData, author);
        }
    }

    /** This method formats the author's name by replacing spaces with underscores to create a valid parameter for API requests.
     * @param author The author whose name is to be formatted.
     * @return The formatted name suitable for API requests.
     */
    private String formatAuthorName(Author author) {
        String firstName = author.getName();
        String lastName = author.getLastName();

        firstName = firstName.replace(" ", "_");
        lastName = lastName.replace(" ", "_");

        return firstName + "_" + lastName;
    }

}