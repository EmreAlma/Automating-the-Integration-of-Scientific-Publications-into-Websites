package com.example.pubsync.service;

import com.example.pubsync.entity.Authors;
import com.example.pubsync.entity.Publications;
import com.example.pubsync.model.Response;
import com.example.pubsync.repository.PublicationsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void savePublications(Response response, Authors author) {
        var convertModel = ConverterService.publicationsList(response);
        convertModel = filterByYear(convertModel, author);
        convertModel = filterService.fetchAndSaveNewPublications(convertModel);
        publicationsRepository.saveAll(convertModel);
    }

    public List<Publications> filterByYear(List<Publications> publications, Authors author){

        List<Publications> filteredList = new ArrayList<>();

        for (Publications publication : publications) {
            if (Integer.parseInt(author.getStartDate()) < Integer.parseInt(publication.getYear()) && Integer.parseInt(publication.getYear()) < Integer.parseInt(author.getQuitDate())) {
                filteredList.add(publication);
            }
        }

        return filteredList;
    }
}
