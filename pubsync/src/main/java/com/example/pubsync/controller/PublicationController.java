package com.example.pubsync.controller;

import com.example.pubsync.model.PublicationView;
import com.example.pubsync.repository.PublicationRepository;
import com.example.pubsync.service.ConverterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publications")
public class PublicationController {

    private final PublicationRepository publicationRepository;
    private final ConverterService converterService;

    public PublicationController(PublicationRepository publicationRepository, ConverterService converterService) {
        this.publicationRepository = publicationRepository;
        this.converterService = converterService;
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:1313")
    public List<PublicationView> getAllPublications() {
        return converterService.convertPublicationViewList(publicationRepository.findAll());
    }
}
