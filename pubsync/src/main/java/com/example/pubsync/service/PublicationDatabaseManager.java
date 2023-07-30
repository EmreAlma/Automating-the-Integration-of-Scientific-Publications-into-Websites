package com.example.pubsync.service;

import com.example.pubsync.entity.Authors;
import com.example.pubsync.model.Response;
import com.example.pubsync.repository.PublicationsRepository;
import org.springframework.stereotype.Service;

@Service
public class PublicationDatabaseManager {

    private final ConverterService ConverterService;

    private final PublicationsRepository publicationsRepository;

    private final FilterService filterService;

    public PublicationDatabaseManager(ConverterService modelConverterService, PublicationsRepository publicationsRepository, FilterService filterService) {
        this.ConverterService = modelConverterService;
        this.publicationsRepository = publicationsRepository;
        this.filterService = filterService;
    }

    public void savePublications(Response response) {
        var convertModel = ConverterService.publicationsList(response);
        convertModel = filterService.fetchAndSaveNewPublications(convertModel);
        publicationsRepository.saveAll(convertModel);
    }
}
