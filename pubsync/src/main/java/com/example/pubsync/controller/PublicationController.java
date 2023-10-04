package com.example.pubsync.controller;

import com.example.pubsync.model.PublicationView;
import com.example.pubsync.repository.PublicationRepository;
import com.example.pubsync.service.ConverterService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    /*@GetMapping("/getbyyear")
    public List<PublicationView> getPublicationByYear(@RequestParam(value = "year") String year){

        return converterService.convertPublicationViewList(publicationRepository.findPublicationsByYear(year));
    }*/

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:1313")
    public List<PublicationView> getAllPublications() {
       /* List<PublicationView> allPublications = new ArrayList<>();

        for (int year = 2019; year <= 2023; year++) {
            String yearStr = String.valueOf(year);
            List<PublicationView> publications = converterService.convertPublicationViewList(publicationRepository.findPublicationsByYear(yearStr));
            allPublications.addAll(publications);
        }

        return allPublications;*/
        return converterService.convertPublicationViewList(publicationRepository.findAll());
    }
}
