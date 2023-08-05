package com.example.pubsync.controller;

import com.example.pubsync.model.PublicationView;
import com.example.pubsync.repository.PublicationRepository;
import com.example.pubsync.service.ConverterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublicationController {

    private final PublicationRepository publicationRepository;
    private final ConverterService converterService;

    public PublicationController(PublicationRepository publicationRepository, ConverterService converterService) {
        this.publicationRepository = publicationRepository;
        this.converterService = converterService;
    }

    @GetMapping("/getbyyear")
    public List<PublicationView> getPublicationByYear(@RequestParam(value = "year") String year){

        return converterService.convertPublicationViewList(publicationRepository.findPublicationsByYear(year));
    }
}
