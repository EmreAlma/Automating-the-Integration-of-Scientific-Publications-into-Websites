package com.example.pubsync.service;

import com.example.pubsync.model.Response;
import com.example.pubsync.repository.PublicationsRepository;
import com.example.pubsync.service.ConverterService;
import org.springframework.stereotype.Service;

@Service
public class PublicationDatabaseManager {

    private final ConverterService ConverterService;

    private final PublicationsRepository publicationsRepository;

    public PublicationDatabaseManager(ConverterService modelConverterService,PublicationsRepository publicationsRepository) {
        this.ConverterService = modelConverterService;
        this.publicationsRepository = publicationsRepository;
    }

    public void savePublications(Response response) {
        var convertModel = ConverterService.publicationsList(response);
        publicationsRepository.saveAll(convertModel);
    }
}
