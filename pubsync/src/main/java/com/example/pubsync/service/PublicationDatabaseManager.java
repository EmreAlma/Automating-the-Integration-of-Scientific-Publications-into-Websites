package com.example.pubsync.service;

import com.example.pubsync.entity.Author;
import com.example.pubsync.model.Response;
import com.example.pubsync.repository.PublicationRepository;
import org.springframework.stereotype.Service;

/**
 * Service class managing database operations for publications.
 * Handles saving and retrieving publications from the database.
 */
@Service
public class PublicationDatabaseManager {

    private final ConverterService ConverterService;

    private final PublicationRepository publicationRepository;

    private final FilterService filterService;

    public PublicationDatabaseManager(ConverterService modelConverterService, PublicationRepository publicationRepository, FilterService filterService) {
        this.ConverterService = modelConverterService;
        this.publicationRepository = publicationRepository;
        this.filterService = filterService;
    }

    /**
     * Saves the publications associated with a specific author to the database.
     * Filters the publications by year and checks for duplicates before saving.
     * @param response The Response object containing publication data.
     * @param author The Author entity associated with the publications.
     */
    public void savePublications(Response response, Author author) {
        var convertModel = ConverterService.convertResponsePublicationsList(response);
        convertModel = filterService.filterByYear(convertModel, author);
        convertModel = filterService.filterAndSaveNewPublications(convertModel);
        publicationRepository.saveAll(convertModel);
    }

}
