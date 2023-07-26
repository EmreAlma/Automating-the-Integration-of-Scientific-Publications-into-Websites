package com.example.pubsync.controller;

import com.example.pubsync.entity.Publications;
import com.example.pubsync.repository.PublicationsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublicationController {

    private final PublicationsRepository publicationsRepository;

    public PublicationController(PublicationsRepository publicationsRepository) {
        this.publicationsRepository = publicationsRepository;
    }

    @GetMapping("/getbyyear")
    public List<Publications> getPublicationByYear(@RequestParam(value = "year") String year){

        return publicationsRepository.findPublicationsByYear(year);
    }
}
