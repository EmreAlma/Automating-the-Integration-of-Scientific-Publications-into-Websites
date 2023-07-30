package com.example.pubsync.controller;

import com.example.pubsync.entity.Publication;
import com.example.pubsync.repository.PublicationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublicationController {

    private final PublicationRepository publicationRepository;

    public PublicationController(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    @GetMapping("/getbyyear")
    public List<Publication> getPublicationByYear(@RequestParam(value = "year") String year){

        return publicationRepository.findPublicationsByYear(year);
    }
}
