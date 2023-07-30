package com.example.pubsync.service;

import com.example.pubsync.entity.Author;
import com.example.pubsync.model.Response;
import com.example.pubsync.repository.PublicationRepository;
import org.springframework.stereotype.Service;

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

    public void savePublications(Response response, Author author) {
        var convertModel = ConverterService.publicationsList(response);
        convertModel = filterService.filterByYear(convertModel, author);
        convertModel = filterService.filterAndSaveNewPublications(convertModel);
        publicationRepository.saveAll(convertModel);
    }

}
