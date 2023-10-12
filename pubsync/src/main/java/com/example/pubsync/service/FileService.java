package com.example.pubsync.service;

import com.example.pubsync.model.PublicationView;
import com.example.pubsync.repository.PublicationRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class FileService {

    private final PublicationRepository publicationRepository;
    private final ConverterService converterService;

    public FileService(PublicationRepository publicationRepository, ConverterService converterService) {
        this.publicationRepository = publicationRepository;
        this.converterService = converterService;
    }

    public void createMarkdownFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("/Users/emrealma/Documents/GitHub/Automating-the-Integration-of-Scientific-Publications-into-Websites/pubsync/src/main/resources/templates/publications.md");
        List<PublicationView> publicationViewList = converterService.convertPublicationViewList(publicationRepository.findAll());

        for (PublicationView publication : publicationViewList) {
            writer.print(publication.getTitle()+"\n");
            writer.print(publication.getPublishAuthors()+"\n");
            writer.print("*"+publication.getVenue()+"\n");
            writer.print(publication.getYear()+"*"+"\n\n");
            writer.print("[Link]("+publication.getPublishLink()+")"+"\n\n");
        }
    }
}
